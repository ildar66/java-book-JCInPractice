package chapter_7.section_1;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

import static chapter_5.section_5.LaunderThrowable.launderThrowable;

/**
 * TimedRun2
 * <p/>
 * Interrupting a task in a dedicated thread
 * @author Brian Goetz and Tim Peierls
 *         Addresses the exception-handling problem of aSecondOfPrimes and the problems with the previous attempt. The thread created to run the task
 *         can have its own execution policy, and even if the task doesn't respond to the interrupt, the timed run method can still return to its
 *         caller. After starting the task thread, timedRun executes a timed join with the newly created thread. After join returns, it checks if an
 *         exception was thrown from the task and if so, rethrows it in the thread calling timedRun. The saved Throwable is shared between the two
 *         threads, and so is declared volatile to safely publish it from the task thread to the timedRun thread.
 *         This version addresses the problems in the previous examples, but because it relies on a timed join, it shares a deficiency with join: we
 *         don't know if control was returned because the thread exited normally or because the join timed out.
 *         This is a flaw in the Thread API, because whether or not the join completes successfully has memory visibility consequences in the Java
 *         Memory Model, but join does not return a status indicating whether it was successful.
 */
public class TimedRun2 {

    private static final ScheduledExecutorService cancelExec = newScheduledThreadPool(1);

    public static void timedRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {

        class RethrowableTask implements Runnable {

            private volatile Throwable t;

            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void rethrow() {
                if (t != null)
                    throw launderThrowable(t);
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(new Runnable() {

            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }
}
