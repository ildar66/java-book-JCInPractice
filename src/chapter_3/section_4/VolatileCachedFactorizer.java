package chapter_3.section_4;

import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.jcip.annotations.ThreadSafe;

/**
 * VolatileCachedFactorizer
 * <p/>
 * Caching the last result using a volatile reference to an immutable holder
 * object
 * @author Brian Goetz and Tim Peierls
 *         @see VolatileCachedFactorizer  uses a OneValueCache to store the cached number and factors. When a thread sets the volatile cache
 *         field to reference a new OneValueCache, the new cached data becomes immediately visible to other threads.
 *         The cache-related operations cannot interfere with each other because One-ValueCache is immutable and the cache field is accessed only once
 *         in each of the relevant code paths. This combination of an immutable holder object for multiple state variables related by an invariant,
 *         and a volatile reference used to ensure its timely visibility, allows VolatileCachedFactorizer to be thread-safe even though it does no
 *         explicit locking.
 */
@ThreadSafe
public class VolatileCachedFactorizer extends GenericServlet implements Servlet {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
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
