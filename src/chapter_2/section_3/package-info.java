/**
 * Created by User on 02.11.2016.
 * Locking section.
 *
 * To preserve state consistency, update related state variables in a single atomic operation.
 *
 * Reentrancy
 * When a thread requests a lock that is already held by another thread, the requesting thread blocks. But because intrinsic locks are reentrant, if a
 * thread tries to acquire a lock that it already holds, the request succeeds. Reentrancy means that locks are acquired on a per-thread rather than
 * per-invocation basis. [7] Reentrancy is implemented by associating with each lock an acquisition count and an owning thread. When the count is
 * zero, the lock is considered unheld. When a thread acquires a previously unheld lock, the JVM records the owner and sets the acquisition count to
 * one. If that same thread acquires the lock again, the count is incremented, and when the owning thread exits the synchronized block, the count is
 * decremented. When the count reaches zero, the lock is released.
 *
 *   Code that would Deadlock if Intrinsic Locks were Not Reentrant.
 *   public class Widget {
        public synchronized void doSomething() {
            ...
        }
    }

     public class LoggingWidget extends Widget {
         public synchronized void doSomething() {
            System.out.println(toString() + ": calling doSomething");
            super.doSomething();
        }
    }


 */
package chapter_2.section_3;