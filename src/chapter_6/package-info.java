/**
 * Created by User on 10.11.2016.
 * Task Execution chapter
 * 
 * Most concurrent applications are organized around the execution of tasks: abstract, discrete units of work.
 * Dividing the work of an application into tasks simplifies program organization,
 * facilitates error recovery by providing natural transaction boundaries,
 * and promotes concurrency by providing a natural structure for parallelizing work.
 *
 * Structuring applications around the execution of tasks can simplify development and facilitate concurrency. The Executor framework permits you to
 * decouple task submission from execution policy and supports a rich variety of execution policies; whenever you find yourself creating threads to
 * perform tasks, consider using an Executor instead. To maximize the benefit of decomposing an application into tasks, you must identify sensible
 * task boundaries. In some applications, the obvious task boundaries work well, whereas in others some analysis may be required to uncover
 * finer-grained exploitable parallelism.
 */
package chapter_6;