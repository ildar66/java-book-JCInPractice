package chapter_1.section_3;

import net.jcip.annotations.NotThreadSafe;

/**
 * UnsafeSequence
 * @author Brian Goetz and Tim Peierls
 *         Thread safety can be unexpectedly subtle because, in the absence of sufficient synchronization, the ordering of operations in multiple
 *         threads is unpredictable and sometimes surprising. UnsafeSequence, which is supposed to generate a sequence of unique
 *         integer values, offers a simple illustration of how the interleaving of actions in multiple threads can lead to undesirable results. It
 *         behaves correctly in a single-threaded environment, but in a multithreaded environment does not
 *
 *         The problem with UnsafeSequence is that with some unlucky timing, two threads could call getNext and receive the same value. Figure 1.1
 *         shows how this can happen. The increment notation, nextValue++, may appear to be a single operation, but is in fact three separate
 *         operations: read the value, add one to it, and write out the new value. Since operations in multiple threads may be arbitrarily
 *         interleaved by the runtime, it is possible for two threads to read the value at the same time, both see the same value, and then both add one to it.
 *         The result is that the same sequence number is returned from multiple calls in different threads.
 */

@NotThreadSafe
public class UnsafeSequence {

    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}
