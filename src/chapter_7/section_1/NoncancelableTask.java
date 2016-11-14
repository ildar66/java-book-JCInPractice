package chapter_7.section_1;

import java.util.concurrent.BlockingQueue;

/**
 * NoncancelableTask
 * <p/>
 * Noncancelable task that restores interruption before exit
 * @author Brian Goetz and Tim Peierls
 *         Activities that do not support cancellation but still call interruptible blocking methods will have to call them in a loop, retrying when
 *         interruption is detected. In this case, they should save the interruption status locally and restore it just before returning
 */
public class NoncancelableTask {

    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                    // fall through and retry
                }
            }
        } finally {
            if (interrupted)
                Thread.currentThread().interrupt();
        }
    }

    interface Task {

    }
}
