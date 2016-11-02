package chapter_2.section_5;

import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * CachedFactorizer
 * <p/>
 * Servlet that caches its last request and result
 * @author Brian Goetz and Tim Peierls
 *         CachedFactorizer restructures the servlet to use two separate synchronized blocks, each limited to a short section of code.
 *         One guards the check-then-act sequence that tests whether we can just return the cached result, and the other guards updating both the
 *         cached number and the cached factors. As a bonus, we've reintroduced the hit counter and added a "cache hit" counter as well, updating
 *         them within the initial synchronized block. Because these counters constitute shared mutable state as well, we must use synchronization
 *         everywhere they are accessed. The portions of code that are outside the synchronized blocks operate exclusively on local (stack-based)
 *         variables, which are not shared across threads and therefore do not require synchronization.
 */
@ThreadSafe
public class CachedFactorizer extends GenericServlet implements Servlet {

    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] {i};
    }
}
