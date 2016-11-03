package chapter_3.section_1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * SynchronizedInteger
 * <p/>
 * Thread-safe mutable integer holder
 * @author Brian Goetz and Tim Peierls
 *         We can make @see {@link MutableInteger} thread safe by synchronizing the getter and setter as shown in SynchronizedInteger.
 *         Synchronizing only the setter would not be sufficient: threads calling get would still be able to see stale values.
 */
@ThreadSafe
public class SynchronizedInteger {

    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
