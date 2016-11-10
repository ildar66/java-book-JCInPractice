/**
 * Created by User on 10.11.2016.
 * Executing Tasks in Threads section.
 *
 *  Disadvantages of Unbounded Thread Creation
     For production use, however, the thread-per-task approach has some practical drawbacks, especially when a large number of threads may be created:

     Thread lifecycle overhead.
        Thread creation and teardown are not free. The actual overhead varies across platforms, but thread creation takes time,
        introducing latency into request processing, and requires some processing activity by the JVM and OS. If requests are frequent and lightweight,
        as in most server applications, creating a new thread for each request can consume significant computing resources.

     Resource consumption.
        Active threads consume system resources, especially memory. When there are more runnable threads than available processors,
        threads sit idle. Having many idle threads can tie up a lot of memory, putting pressure on the garbage collector, and having many threads competing
        for the CPUs can impose other performance costs as well. If you have enough threads to keep all the CPUs busy, creating more threads won't help
        and may even hurt.

     Stability.
        There is a limit on how many threads can be created. The limit varies by platform and is affected by factors including JVM invocation
        parameters, the requested stack size in the Thread constructor, and limits on threads placed by the underlying operating system.
        When you hit this limit, the most likely result is an OutOfMemoryError. trying to recover from such an error is very risky; it is far easier to structure your program to avoid hitting this limit.
 */
package chapter_6.section_1;