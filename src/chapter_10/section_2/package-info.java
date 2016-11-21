/**
 * Created by User on 21.11.2016.
 * Avoiding and Diagnosing Deadlocks section.
 * 
 * A program that never acquires more than one lock at a time cannot experience lock-ordering deadlock. Of course, this is not always practical, but
 * if you can get away with it, it's a lot less work. If you must acquire multiple locks, lock ordering must be a part of your design: try to minimize
 * the number of potential locking interactions, and follow and document a lock-ordering protocol for locks that may be acquired together.
 * In programs that use fine-grained locking, audit your code for deadlock freedom using a two-part strategy: first, identify where multiple locks
 * could be acquired (try to make this a small set), and then perform a global analysis of all such instances to ensure that lock ordering is
 * consistent across your entire program. Using open calls wherever possible simplifies this analysis substantially. With no non-open calls, finding
 * instances where multiple locks are acquired is fairly easy, either by code review or by automated bytecode or source code analysis.
 */
package chapter_10.section_2;