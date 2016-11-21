/**
 * Created by User on 18.11.2016.
 * Deadlock section.
 *
 * A program will be free of lock-ordering deadlocks if all threads acquire the locks they need in a fixed global order.
 *
 * Invoking an alien method with a lock held is asking for liveness trouble. The alien method might acquire other locks (risking deadlock) or block
 * for an unexpectedly long time, stalling other threads that need the lock you hold.
 * @see chapter_10.section_1.CooperatingDeadlock
 *
 * Strive to use open calls throughout your program. Programs that rely on open calls are far easier to analyze for deadlock-freedom than those
 * that allow calls to alien methods with locks held. @see chapter_10.section_1.{@link chapter_10.section_1.CooperatingNoDeadlock}
 * Restructuring a synchronized block to allow open calls can sometimes have undesirable consequences, since it takes an operation that was atomic
 * and makes it not atomic. In many cases, the loss of atomicity is perfectly acceptable.
 *
 * In some cases, however, the loss of atomicity is a problem, and here you will have to use another technique to achieve atomicity.
 * One such technique is to structure a concurrent object so that only one thread can execute the code path following the open call.
 * For example, when shutting down a service, you may want to wait for in-progress operations to complete and then release resources
 * used by the service. Holding the service lock while waiting for operations to complete is inherently deadlock-prone, but releasing
 * the service lock before the service is shut down may let other threads start new operations.
 * The solution is to hold the lock long enough to update the service state to "shutting down" so that other threads wanting to start
 * new operationsincluding shutting down the servicesee that the service is unavailable, and do not try.
 * You can then wait for shutdown to complete, knowing that only the shutdown thread has access to the service state after the open call completes.
 * Thus, rather than using locking to keep the other threads out of a critical section of code, this technique relies on constructing protocols
 * so that other threads don't try to get in.
 *
 * Just as threads can deadlock when they are each waiting for a lock that the other holds and will not release, they can also deadlock when
 * waiting for resources.Say you have two pooled resources, such as connection pools for two different databases. Resource pools are usually
 * implemented with semaphores (see Section 5.5.3) to facilitate blocking when the pool is empty. If a task requires connections to both databases
 * and the two resources are not always requested in the same order, thread A could be holding a connection to database D1 while waiting for a
 * connection to database D2, and thread B could be holding a connection to D2 while waiting for a connection to D1.
 * (The larger the pools are, the less likely this is to occur; if each pool has N connections, deadlock requires N sets of cyclically waiting
 * threads and a lot of unlucky timing.).
 *
 * Another form of resource-based deadlock is thread-starvation deadlock. We saw an example of this hazard in Section 8.1.1, where a task that
 * submits a task and waits for its result executes in a single-threaded Executor. In that case, the first task will wait forever, permanently
 * stalling that task and all others waiting to execute in that Executor. Tasks that wait for the results of other tasks are the primary source
 * of thread-starvation deadlock; bounded pools and interdependent tasks do not mix well.
 */
package chapter_10.section_1;