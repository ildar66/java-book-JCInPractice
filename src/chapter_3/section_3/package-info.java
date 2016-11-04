/**
 * Created by User on 03.11.2016.
 * Thread Confinement section.
 * 
 * Accessing shared, mutable data requires using synchronization; one way to avoid this requirement is to not share. If data is only accessed from a
 * single thread, no synchronization is needed. This technique, thread confinement, is one of the simplest ways to achieve thread safety. When an
 * object is confined to a thread, such usage is automatically thread-safe even if the confined object itself is not
 */
package chapter_3.section_3;