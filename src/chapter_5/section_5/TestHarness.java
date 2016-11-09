package chapter_5.section_5;

import java.util.concurrent.CountDownLatch;

/**
 * TestHarness
 * <p/>
 * Using CountDownLatch for starting and stopping threads in timing tests
 * @author Brian Goetz and Tim Peierls
 *         A latch is a synchronizer that can delay the progress of threads until it reaches its terminal state. A latch acts as a gate:
 *         until the latch reaches the terminal state the gate is closed and no thread can pass, and in the terminal state the gate opens, allowing
 *         all threads to pass. Once the latch reaches the terminal state, it cannot change state again, so it remains open forever.
 *         
 *         Latches can be used to ensure that certain activities do not proceed until other one-time activities complete, such as:
 *
 *         Ensuring that a computation does not proceed until resources it needs have been initialized. A simple binary (two-state) latch could be
 *         used to indicate "Resource R has been initialized", and any activity that requires R would wait first on this latch.
 *
 *         Ensuring that a service does not start until other services on which it depends have started. Each service would have an associated binary
 *         latch; starting service S would involve first waiting on the latches for other services on which S depends, and then releasing the S latch
 *         after startup completes so any services that depend on S can then proceed.
 *
 *         Waiting until all the parties involved in an activity, for instance the players in a multi-player game, are ready to proceed. In this
 *         case, the latch reaches the terminal state after all the players are ready.
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {

                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
