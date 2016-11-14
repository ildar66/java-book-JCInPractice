package chapter_7.section_1;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * PrimeProducer
 * <p/>
 * Using interruption for cancellation
 * @author Brian Goetz and Tim Peierls
 *         There are two points in each loop iteration where interruption may be detected: in the blocking put call, and by explicitly polling the
 *         interrupted status in the loop header. The explicit test is not strictly necessary here because of the blocking put call, but it makes
 *         PrimeProducer more responsive to interruption because it checks for interruption before starting the lengthy task of searching for a prime,
 *         rather than after. When calls to interruptible blocking methods are not frequent enough to deliver the desired responsiveness, explicitly
 *         testing the interrupted status can help.
 */
public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
            /* Allow thread to exit */
        }
    }

    public void cancel() {
        interrupt();
    }
}
