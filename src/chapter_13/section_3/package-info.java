/**
 * Created by User on 25.11.2016.
 * Fairness section.
 * 
 * The ReentrantLock constructor offers a choice of two fairness options: create a nonfair lock (the default) or a fair lock. Threads acquire a fair
 * lock in the order in which they requested it, whereas a nonfair lock permits barging: threads requesting a lock can jump ahead of the queue of
 * waiting threads if the lock happens to be available when it is requested. (Semaphore also offers the choice of fair or nonfair acquisition
 * ordering.) Nonfair ReentrantLocks do not go out of their way to promote bargingthey simply don't prevent a thread from barging if it shows up at
 * the right time. With a fair lock, a newly requesting thread is queued if the lock is held by another thread or if threads are queued waiting for
 * the lock; with a nonfair lock, the thread is queued only if the lock is currently held.[4]
 *
 * [4] The polled tryLock always barges, even for fair locks.
 *
 * Wouldn't we want all locks to be fair? After all, fairness is good and unfairness is bad, right? (Just ask your kids.) When it comes to locking,
 * though, fairness has a significant performance cost because of the overhead of suspending and resuming threads. In practice, a statistical
 * fairness guaranteepromising that a blocked thread will eventually acquire the lockis often good enough, and is far less expensive to deliver. Some
 * algorithms rely on fair queueing to ensure their correctness, but these are unusual. In most cases, the performance benefits of nonfair locks
 * outweigh the benefits of fair queueing.
 */
package chapter_13.section_3;