package chapter_2.section_3;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.jcip.annotations.NotThreadSafe;

/**
 * UnsafeCachingFactorizer
 * Servlet that attempts to cache its last result without adequate atomicity.
 * @author Brian Goetz and Tim Peierls
 *         The definition of thread safety requires that invariants be preserved regardless of timing or interleaving of operations in multiple
 *         threads. One invariant of UnsafeCachingFactorizer is that the product of the factors cached in lastFactors equal the value cached in
 *         lastNumber; our servlet is correct only if this invariant always holds. When multiple variables participate in an invariant, they are not
 *         independent: the value of one constrains the allowed value(s) of the others. Thus when updating one, you must update the others in
 *         the same atomic operation.
 */

@NotThreadSafe
public class UnsafeCachingFactorizer extends GenericServlet implements Servlet {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get()))
            encodeIntoResponse(resp, lastFactors.get());
        else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(resp, factors);
        }
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
