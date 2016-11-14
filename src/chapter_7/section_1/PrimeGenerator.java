package chapter_7.section_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * PrimeGenerator
 * <p/>
 * Using a volatile field to hold cancellation state
 * @author Brian Goetz and Tim Peierls
*         PrimeGenerator shows a sample use of this class that lets the prime generator run for one second before cancelling it. The generator won't necessarily
*         stop after exactly one second, since there may be some delay between the time that cancellation is requested and the time that the run loop
*         next checks for cancellation. The cancel method is called from a finally block to ensure that the prime generator is cancelled even if the
*         the call to sleep is interrupted. If cancel were not called, the prime-seeking thread would run forever, consuming CPU cycles and
*         preventing the JVM from exiting.
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    private volatile boolean cancelled;

    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        exec.execute(generator);
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
}
