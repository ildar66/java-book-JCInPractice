package chapter_7.section_1;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * BrokenPrimeProducer
 * <p/>
 * Unreliable cancellation that can leave producers stuck in a blocking operation
 * @author Brian Goetz and Tim Peierls
 *         BrokenPrimeProducer illustrates this problem. The producer thread generates primes and places them on a blocking queue. If
 *         the producer gets ahead of the consumer, the queue will fill up and put will block. What happens if the consumer tries to cancel the
 *         producer task while it is blocked in put? It can call cancel which will set the cancelled flag but the producer will never check the flag
 *         because it will never emerge from the blocking put (because the consumer has stopped retrieving primes from the queue).
 */
class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled)
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
        }
    }

    public void cancel() {
        cancelled = true;
    }

/*    void consumePrimes() throws InterruptedException {
        BlockingQueue<BigInteger> primes = ...;
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try {
            while (needMorePrimes())
                consume(primes.take());
        } finally {
            producer.cancel();
        }
    }*/

}
