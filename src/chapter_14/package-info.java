/**
 * Created by User on 25.11.2016.
 * Building Custom Synchronizers chapter.
 *
 * If you need to implement a state-dependent class - one whose methods must block if a state-based precondition does not hold - the best strategy is
 * usually to build upon an existing library class such as Semaphore, BlockingQueue, or CountDownLatch, as in ValueLatch. However,
 * sometimes existing library classes do not provide a sufficient foundation; in these cases, you can build your own synchronizers using intrinsic
 * condition queues, explicit Condition objects, or AbstractQueuedSynchronizer. Intrinsic condition queues are tightly bound to intrinsic locking,
 * since the mechanism for managing state dependence is necessarily tied to the mechanism for ensuring state consistency. Similarly, explicit
 * Conditions are tightly bound to explicit Locks, and offer an extended feature set compared to intrinsic condition queues, including multiple wait
 * sets per lock, interruptible or uninterruptible condition waits, fair or nonfair queuing, and deadline-based waiting.
 */
package chapter_14;