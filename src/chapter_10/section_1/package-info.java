/**
 * Created by User on 18.11.2016.
 * Deadlock section.
 *
 * A program will be free of lock-ordering deadlocks if all threads acquire the locks they need in a fixed global order.
 *
 * Invoking an alien method with a lock held is asking for liveness trouble. The alien method might acquire other locks (risking deadlock) or block
 * for an unexpectedly long time, stalling other threads that need the lock you hold.
 * @see chapter_10.section_1.CooperatingDeadlock
 *
 * Strive to use open calls throughout your program. Programs that rely on open calls are far easier to analyze for deadlock-freedom than those
 * that allow calls to alien methods with locks held. @see chapter_10.section_1.{@link chapter_10.section_1.CooperatingNoDeadlock}
 * Restructuring a synchronized block to allow open calls can sometimes have undesirable consequences, since it takes an operation that was atomic
 * and makes it not atomic. In many cases, the loss of atomicity is perfectly acceptable
 */
package chapter_10.section_1;