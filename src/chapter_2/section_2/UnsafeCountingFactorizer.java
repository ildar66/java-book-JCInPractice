package chapter_2.section_2;

import java.math.BigInteger;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.jcip.annotations.NotThreadSafe;

/**
 * UnsafeCountingFactorizer *
 * Servlet that counts requests without the necessary synchronization
 * @author Brian Goetz and Tim Peierls
 *         Unfortunately, UnsafeCountingFactorizer is not thread-safe, even though it would work just fine in a single-threaded environment.
 *         Just like UnsafeSequence on page 6, it is susceptible to lost updates. While the increment operation, ++count, may look like a single
 *         action because of its compact syntax, it is not atomic, which means that it does not execute as a single, indivisible operation. Instead,
 *         it is a shorthand for a sequence of three discrete operations: fetch the current value, add one to it, and write the new value back. This
 *         is an example of a read-modify-write operation, in which the resulting state is derived from the previous state.
 */
@NotThreadSafe
public class UnsafeCountingFactorizer extends GenericServlet implements Servlet {

    private long count = 0;

    public long getCount() {
        return count;
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] {i};
    }
}
