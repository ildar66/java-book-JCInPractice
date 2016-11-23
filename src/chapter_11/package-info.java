/**
 * Created by User on 21.11.2016.
 * Performance and Scalability chapter.
 *
 * First make your program right, then make it fastand then only if your performance requirements and measurements tell you it needs to be faster.
 * In designing a concurrent application, squeezing out the last bit of performance is often the least of your concerns.
 *
 * Because one of the most common reasons to use threads is to exploit multiple processors, in discussing the performance of concurrent applications,
 * we are usually more concerned with throughput or scalability than we are with raw service time. Amdahl's law tells us that the scalability of an
 * application is driven by the proportion of code that must be executed serially. Since the primary source of serialization in Java programs is the
 * exclusive resource lock, scalability can often be improved by spending less time holding locks, either by reducing lock granularity, reducing the
 * duration for which locks are held, or replacing exclusive locks with nonexclusive or nonblocking alternatives.
 */
package chapter_11;