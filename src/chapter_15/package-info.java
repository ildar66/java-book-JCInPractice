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
 */
package chapter_15;