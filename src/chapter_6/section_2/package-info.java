/**
 * Created by User on 10.11.2016.
 * The Executor Framework section.
 *
 * Execution Policies
 * The value of decoupling submission from execution is that it lets you easily specify, and subsequently change without great difficulty, the
 * execution policy for a given class of tasks. An execution policy specifies the "what, where, when, and how" of task execution, including:
 *
 * In what thread will tasks be executed?

 In what order should tasks be executed (FIFO, LIFO, priority order)?

 How many tasks may execute concurrently?

 How many tasks may be queued pending execution?

 If a task has to be rejected because the system is overloaded, which task should be selected as the victim, and how should the application be notified?

 What actions should be taken before or after executing a task?

 Execution policies are a resource management tool, and the optimal policy depends on the available computing resources and
 your quality-of-service requirements. By limiting the number of concurrent tasks, you can ensure that the application does not fail due to
 resource exhaustion or suffer performance problems due to contention for scarce resources.
 Separating the specification of execution policy from task submission makes it practical to select an execution policy at deployment time
 that is matched to the available hardware.

 Whenever you see code of the form:

    new Thread(runnable).start()

 and you think you might at some point want a more flexible execution policy, seriously consider replacing it with the use of an Executor.
 */
package chapter_6.section_2;