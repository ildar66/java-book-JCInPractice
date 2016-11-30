/**
 * Created by User on 29.11.2016.
 * Nonblocking Algorithms section.
 * Lock-based algorithms are at risk for a number of liveness failures. If a thread holding a lock is delayed due to blocking I/O, page fault, or
 * other delay, it is possible that no thread will make progress. An algorithm is called nonblocking if failure or suspension of any thread cannot
 * cause failure or suspension of another thread; an algorithm is called lock-free if, at each step, some thread can make progress.
 */
package chapter_15.section_4;