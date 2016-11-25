/**
 * Created by User on 24.11.2016.
 * Explicit Locks chapter.
 *
 * Before Java 5.0, the only mechanisms for coordinating access to shared data were synchronized and volatile. Java 5.0 adds another option:
 * ReentrantLock. Contrary to what some have written, ReentrantLock is not a replacement for intrinsic locking, but rather an alternative with
 * advanced features for when intrinsic locking proves too limited.
 *
 * Explicit Locks offer an extended feature set compared to intrinsic locking, including greater flexibility in dealing with lock unavailability and
 * greater control over queueing behavior. But ReentrantLock is not a blanket substitute for synchronized; use it only when you need features that
 * synchronized lacks.
 * 
 * Read-write locks allow multiple readers to access a guarded object concurrently, offering the potential for improved scalability when accessing
 * read-mostly data structures.
 */
package chapter_13;