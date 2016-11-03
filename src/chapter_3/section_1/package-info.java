/**
 * Created by User on 03.11.2016.
 * Visibility section.
 *
 * Visibility is subtle because the things that can go wrong are so counterintuitive. In a single-threaded environment, if you write a value to a
 * variable and later read that variable with no intervening writes, you can expect to get the same value back. This seems only natural. It may be
 * hard to accept at first, but when the reads and writes occur in different threads, this is simply not the case. In general, there is no guarantee
 * that the reading thread will see a value written by another thread on a timely basis, or even at all. In order to ensure visibility of memory
 * writes across threads, you must use synchronization.
 *
 * In the absence of synchronization, the compiler, processor, and runtime can do some downright weird things to the order in which operations appear
 * to execute. Attempts to reason about the order in which memory actions "must" happen in insufflciently synchronized multithreaded programs will
 * almost certainly be incorrect.
 *
 * Volatile Variables:
 * The Java language also provides an alternative, weaker form of synchronization, volatile variables, to ensure that updates to a variable
 * are propagated predictably to other threads. When a field is declared volatile, the compiler and runtime are put on notice that this variable
 * is shared and that operations on it should not be reordered with other memory operations. Volatile variables are not cached in registers or
 * in caches where they are hidden from other processors, so a read of a volatile variable always returns the most recent write by any thread.
 *
 * So from a memory visibility perspective, writing a volatile variable is like exiting a synchronized block
 * and reading a volatile variable is like entering a synchronized block.
 *
 * Use volatile variables only when they simplify implementing and verifying your synchronization policy;
 * avoid using volatile variables when veryfing correctness would require subtle reasoning about visibility.
 * Good uses of volatile variables include ensuring the visibility of their own state, that of the object they refer to,
 * or indicating that an important lifecycle event (such as initialization or shutdown) has occurred.
 *
 * Locking can guarantee both visibility and atomicity; volatile variables can only guarantee visibility
 * 
 * You can use volatile variables only when all the following criteria are met:

        Writes to the variable do not depend on its current value, or you can ensure that only a single thread ever updates the value;

        The variable does not participate in invariants with other state variables; and

        Locking is not required for any other reason while the variable is being accessed.
 */
package chapter_3.section_1;