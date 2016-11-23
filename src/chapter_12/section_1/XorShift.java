package chapter_12.section_1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * XorShift
 * @author Brian Goetz and Tim Peierls
 *         Rather than using a general-purpose RNG, it is better to use simple pseudorandom functions. You don't need high-quality randomness;
 *         all you need is enough randomness to ensure the numbers change from run to run. The xor-Shift function (Marsaglia, 2003) is among
 *         the cheapest mediumquality random number functions. Starting it off with values based on hashCode and nanoTime makes the sums both
 *         unguessable and almost always different for each run.
 */
public class XorShift {

    static final AtomicInteger seq = new AtomicInteger(8862213);
    int x = -1831433054;

    public XorShift(int seed) {
        x = seed;
    }

    public XorShift() {
        this((int) System.nanoTime() + seq.getAndAdd(129));
    }

    public int next() {
        x ^= x << 6;
        x ^= x >>> 21;
        x ^= (x << 7);
        return x;
    }
}
