/**
 * Created by User on 01.11.2016.
 * A (Very) Brief History of Concurrency

 * Several motivating factors led to the development of operating systems that allowed multiple programs to execute simultaneously:

    Resource utilization. Programs sometimes have to wait for external operations such as input or output, and while waiting can do no useful work.
    It is more efficient to use that wait time to let another program run.

    Fairness. Multiple users and programs may have equal claims on the machine's resources.
    It is preferable to let them share the computer via finer-grained time slicing than to let one program run to completion and then start another.

    Convenience. It is often easier or more desirable to write several programs that each perform a single task and have them coordinate
    with each other as necessary than to write a single program that performs all the tasks.

 */
package chapter_1.section_1;