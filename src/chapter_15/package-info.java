/**
 * Created by User on 28.11.2016.
 * Atomic Variables and Nonblocking Synchronization chapter.
 *
 * Many of the classes in java.util.concurrent, such as Semaphore and ConcurrentLinkedQueue, provide better performance and scalability than
 * alternatives using synchronized. In this chapter, we take a look at the primary source of this performance boost: atomic variables and nonblocking
 * synchronization.
 * 
 * Much of the recent research on concurrent algorithms has focused on nonblocking algorithms, which use low-level atomic machine instructions such
 * as compare-and-swap instead of locks to ensure data integrity under concurrent access. Nonblocking algorithms are used extensively in operating
 * systems and JVMs for thread and process scheduling, garbage collection, and to implement locks and other concurrent data structures.
 *
 * Nonblocking algorithms maintain thread safety by using low-level concurrency primitives such as compare-and-swap instead of locks.
 * These low-level primitives are exposed through the atomic variable classes, which can also be used as "better volatile variables" providing
 * atomic update operations for integers and object references.
 *
 * Nonblocking algorithms are difficult to design and implement, but can offer better scalability under typical conditions and greater resistance
 * to liveness failures. Many of the advances in concurrent performance from one JVM version to the next come from the use of nonblocking algorithms,
 * both within the JVM and in the platform libraries.
 */
package chapter_15;