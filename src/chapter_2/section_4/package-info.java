/**
 * Created by User on 02.11.2016.
 * Guarding State with Locks section.
 *
 * For each mutable state variable that may be accessed by more than one thread, all accesses to that variable must be performed with the same lock
 * held. In this case, we say that the variable is guarded by that lock.
 *
 * Every shared, mutable variable should be guarded by exactly one lock. Make it clear to maintainers which lock that is.
 */
package chapter_2.section_4;