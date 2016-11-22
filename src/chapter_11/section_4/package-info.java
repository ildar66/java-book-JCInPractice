/**
 * Created by User on 22.11.2016.
 * Reducing Lock Contention section.
 *
 * The principal threat to scalability in concurrent applications is the exclusive resource lock.
 *
 * There are three ways to reduce lock contention:

        Reduce the duration for which locks are held;

        Reduce the frequency with which locks are requested; or

        Replace exclusive locks with coordination mechanisms that permit greater concurrency.
 */
package chapter_11.section_4;