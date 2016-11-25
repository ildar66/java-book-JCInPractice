package chapter_14.section_1;

import chapter_12.section_1.BaseBoundedBuffer;
import net.jcip.annotations.ThreadSafe;

/**
 * SleepyBoundedBuffer
 * <p/>
 * Bounded buffer using crude blocking
 * @author Brian Goetz and Tim Peierls
 *         SleepyBoundedBuffer in Listing attempts to spare callers the inconvenience of implementing the retry logic on each call by
 *         encapsulating the same crude "poll and sleep" retry mechanism within the put and take operations. If the buffer is empty, take sleeps
 *         until
 *         another thread puts some data into the buffer; if the buffer is full, put sleeps until another thread makes room by removing some data.
 *         This approach encapsulates precondition management and simplifies using the bufferdefinitely a step in the right direction.
 *         The implementation of SleepyBoundedBuffer is more complicated than the previous attempt.[3] The buffer code must test the appropriate
 *         state
 *         condition with the buffer lock held, because the variables that represent the state condition are guarded by the buffer lock. If the test
 *         fails, the executing thread sleeps for a while, first releasing the lock so other threads can access the buffer.[4] Once the thread wakes
 *         up, it reacquires the lock and tries again, alternating between sleeping and testing the state condition until the operation can proceed.
 *         [3] We will spare you the details of Snow White's other five bounded buffer implementations, especially SneezyBoundedBuffer.
 *         [4] It is usually a bad idea for a thread to go to sleep or otherwise block with a lock held, but in this case is even worse because the
 *         desired condition (buffer is full/empty) can never become true if the lock is not released!
 *         From the perspective of the caller, this works nicelyif the operation can proceed immediately, it does, and otherwise it blocksand the
 *         caller need not deal with the mechanics of failure and retry. Choosing the sleep granularity is a tradeoff between responsiveness and CPU
 *         usage; the smaller the sleep granularity, the more responsive, but also the more CPU resources consumed. Figure 14.1 shows how sleep
 *         granularity can affect responsiveness: there may be a delay between when buffer space becomes available and when the thread wakes up and
 *         checks again.
 */
@ThreadSafe
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    int SLEEP_GRANULARITY = 60;

    public SleepyBoundedBuffer() {
        this(100);
    }

    public SleepyBoundedBuffer(int size) {
        super(size);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty())
                    return doTake();
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }
}
