/**
 * Created by User on 02.11.2016.
 * Sharing Objects
 *
 * Locking and Visibility:
 * 
 * When thread A executes a synchronized block, and subsequently thread B enters a synchronized block guarded by the same lock, the values of
 * variables that were visible to A prior to releasing the lock are guaranteed to be visible to B upon acquiring the lock. In other words,
 * everything A did in or prior to a synchronized block is visible to B when it executes a synchronized block guarded by the same lock.
 * Without synchronization, there is no such guarantee.
 *
 * Locking is not just about mutual exclusion; it is also about memory visibility. To ensure that all threads see the most up-to-date values of shared
 * mutable variables, the reading and writing threads must synchronize on a common lock.
 */
package chapter_3;