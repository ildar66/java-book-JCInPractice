/**
 * Created by User on 03.11.2016.
 * Thread Confinement section.
 *
 * Accessing shared, mutable data requires using synchronization; one way to avoid this requirement is to not share. If data is only accessed from a
 * single thread, no synchronization is needed. This technique, thread confinement, is one of the simplest ways to achieve thread safety. When an
 * object is confined to a thread, such usage is automatically thread-safe even if the confined object itself is not
 *
 * A special case of thread confinement applies to volatile variables. It is safe to perform read-modify-write operations on shared volatile
 * variables as long as you ensure that the volatile variable is only written from a single thread. In this case, you are confining the modification
 * to a single thread to prevent race conditions, and the visibility guarantees for volatile variables ensure that other threads
 * see the most up-to-date value.
 */
package chapter_3.section_3;