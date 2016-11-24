/**
 * Created by User on 24.11.2016.
 * Complementary Testing Approaches section.
 *
 * As of this writing, FindBugs includes detectors for the following concurrencyrelated bug patterns, and more are being added all the time:

 Inconsistent synchronization.
 Many objects follow the synchronization policy of guarding all variables with the object's intrinsic lock.
 If a field is accessed frequently but not always with the this lock held, this may indicate that the synchronization policy is not being consistently followed.
 Analysis tools must guess at the synchronization policy because Java classes do not have formal concurrency specifications.
 In the future, if annotations such as @GuardedBy are standardized, auditing tools could interpret annotations rather than having to guess at
 the relationship between variables and locks, thus improving the quality of analysis.

 Invoking THRead.run.
 THRead implements Runnable and therefore has a run method. However, it is almost always a mistake to call Thread.run directly;
 usually the programmer meant to call THRead.start.

 Unreleased lock.
 Unlike intrinsic locks, explicit locks (see Chapter 13) are not automatically released when control exits the scope in which they were acquired.
 The standard idiom is to release the lock from a finally block; otherwise the lock can remain unreleased in the event of an Exception.

 Empty synchronized block.
 While empty synchronized blocks do have semantics under the Java Memory Model, they are frequently used incorrectly,
 and there are usually better solutions to whatever problem the developer was trying to solve.

 Double-checked locking.
 Double-checked locking is a broken idiom for reducing synchronization overhead in lazy initialization (see Section 16.2.4) that involves reading
 a shared mutable field without appropriate synchronization.

 Starting a thread from a constructor.
 Starting a thread from a constructor introduces the risk of subclassing problems, and can allow the this reference to escape the constructor.

 Notification errors.
 The notify and notifyAll methods indicate that an object's state may have changed in a way that would unblock threads that are waiting on
 the associated condition queue. These methods should be called only when the state associated with the condition queue has changed.
 A synchronized block that calls notify or notifyAll but does not modify any state is likely to be an error. (See Chapter 14.)

 Condition wait errors.
 When waiting on a condition queue, Object.wait or Condition. await should be called in a loop, with the appropriate lock held,
 after testing some state predicate (see Chapter 14). Calling Object.wait or Condition.await without the lock held, not in a loop,
 or without testing some state predicate is almost certainly an error.

 Misuse of Lock and Condition.
 Using a Lock as the lock argument for a synchronized block is likely to be a typo, as is calling Condition.wait instead of await
 (though the latter would likely be caught in testing, since it would throw an IllegalMonitorStateException the first time it was called).

 Sleeping or waiting while holding a lock.
 Calling Thread.sleep with a lock held can prevent other threads from making progress for a long time and is therefore a potentially serious
 liveness hazard. Calling Object.wait or Condition.await with two locks held poses a similar hazard.

 Spin loops.
 Code that does nothing but spin (busy wait) checking a field for an expected value can waste CPU time and, if the field is not volatile,
 is not guaranteed to terminate. Latches or condition waits are often a better technique when waiting for a state transition to occur.

 */
package chapter_12.section_4;