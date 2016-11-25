/**
 * Created by User on 25.11.2016.
 * Performance Considerations section.
 *
 * When ReentrantLock was added in Java 5.0, it offered far better contended performance than intrinsic locking. For synchronization primitives,
 * contended performance is the key to scalability: if more resources are expended on lock management and scheduling, fewer are available for the
 * application. A better lock implementation makes fewer system calls, forces fewer context switches, and initiates less memory-synchronization
 * traffic on the shared memory bus, operations that are time-consuming and divert computing resources from the program.
 *
 * Java 6 uses an improved algorithm for managing intrinsic locks, similar to that used by ReentrantLock, that closes the scalability gap
 * considerably.
 *
 * Performance is a moving target; yesterday's benchmark showing that X is faster than Y may already be out of date today.
 */
package chapter_13.section_2;