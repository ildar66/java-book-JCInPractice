/**
 * Created by User on 02.11.2016.
 * Guarding State with Locks section.
 *
 * For each mutable state variable that may be accessed by more than one thread, all accesses to that variable must be performed with the same lock
 * held. In this case, we say that the variable is guarded by that lock.
 *
 * There is no inherent relationship between an object's intrinsic lock and its state; an object's fields need not be guarded by its intrinsic lock,
 * though this is a perfectly valid locking convention that is used by many classes. Acquiring the lock associated with an object does not prevent
 * other threads from accessing that objectthe only thing that acquiring a lock prevents any other thread from doing is acquiring that same lock.
 * The fact that every object has a built-in lock is just a convenience so that you needn't explicitly create lock objects.
 * It is up to you to construct locking protocols or synchronization policies that let you access shared state safely,
 * and to use them consistently throughout your program.
 *
 * Every shared, mutable variable should be guarded by exactly one lock. Make it clear to maintainers which lock that is.
 *
 * For every invariant that involves more than one variable, all the variables involved in that invariant must be guarded by the same lock.
 */
package chapter_2.section_4;