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
 */
package chapter_3.section_1;