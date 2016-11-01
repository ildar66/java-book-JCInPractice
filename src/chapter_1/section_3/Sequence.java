package chapter_1.section_3;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Sequence
 * @author Brian Goetz and Tim Peierls
 *         In the absence of synchronization, the compiler, hardware, and runtime are allowed to take substantial liberties with the timing and
 *         ordering of actions, such as caching variables in registers or processor-local caches where they are temporarily (or even permanently)
 *         invisible to other threads. These tricks are in aid of better performance and are generally desirable, but they place a burden on the
 *         developer to clearly identify where data is being shared across threads so that these optimizations do not undermine safety.
 */

@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}
