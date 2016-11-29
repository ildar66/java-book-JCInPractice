/**
 * Created by User on 29.11.2016.
 * Disadvantages of Locking section.
 *
 * Modern JVMs can optimize uncontended lock acquisition and release fairly effectively, but if multiple threads request the lock at the same time the
 * JVM enlists the help of the operating system. If it gets to this point, some unfortunate thread will be suspended and have to be resumed later.[1]
 * When that thread is resumed, it may have to wait for other threads to finish their scheduling quanta before it is actually scheduled. Suspending
 * and resuming a thread has a lot of overhead and generally entails a lengthy interruption. For lock-based classes with fine-grained operations (such
 * as the synchronized collections classes, where most methods contain only a few operations), the ratio of scheduling overhead to useful work can be
 * quite high when the lock is frequently contended.
 *
 * [1] A smart JVM need not necessarily suspend a thread if it contends for a lock; it could use profiling data to decide adaptively between
 * suspension and spin locking based on how long the lock has been held during previous acquisitions.
 *
 * Volatile variables are a lighter-weight synchronization mechanism than locking because they do not involve context switches or thread scheduling.
 * However, volatile variables have some limitations compared to locking: while they provide similar visibility guarantees, they cannot be used to
 * construct atomic compound actions. This means that volatile variables cannot be used when one variable depends on another, or when the new value of
 * a variable depends on its old value. This limits when volatile variables are appropriate, since they cannot be used to reliably implement common
 * tools such as counters or mutexes.[2]
 *
 * [2] It is theoretically possible, though wholly impractical, to use the semantics of volatile to construct mutexes and other synchronizers; see
 * (Raynal, 1986).
 *
 * For example, while the increment operation (++i) may look like an atomic operation, it is actually three distinct operationsfetch the current value
 * of the variable, add one to it, and then write the updated value back. In order to not lose an update, the entire read-modify-write operation must
 * be atomic. So far, the only way we've seen to do this is with locking, as in @see {@link chapter_4.section_1.Counter}.
 * Counter is thread-safe, and in the presence of little or no contention performs just fine. But under contention, performance suffers because of
 * context-switch overhead and scheduling delays. When locks are held so briefly, being put to sleep is a harsh penalty for asking for the lock at the
 * wrong time.
 * 
 * Locking has a few other disadvantages. When a thread is waiting for a lock, it cannot do anything else. If a thread holding a lock is delayed (due
 * to a page fault, scheduling delay, or the like), then no thread that needs that lock can make progress.
 */
package chapter_15.section_1;