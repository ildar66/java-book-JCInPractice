/**
 * Created by User on 29.11.2016.
 * Atomic Variable Classes section.
 * 
 * The performance reversal between locks and atomics at differing levels of contention illustrates the strengths and weaknesses of each. With low to
 * moderate contention, atomics offer better scalability; with high contention, locks offer better contention avoidance. (CAS-based algorithms also
 * outperform lock-based ones on single-CPU systems, since a CAS always succeeds on a single-CPU system except in the unlikely case that a thread is
 * preempted in the middle of the read-modify-write operation.)
 */
package chapter_15.section_3;