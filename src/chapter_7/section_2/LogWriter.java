package chapter_7.section_2;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LogWriter
 * <p/>
 * Producer-consumer logging service with no shutdown support
 * @author Brian Goetz and Tim Peierls
 *         LogWriter shows a simple logging service in which the logging activity is moved to a separate logger thread. Instead of having the thread
 *         that produces the message write it directly to the output stream, LogWriter hands it off to the logger thread via a BlockingQueue and the
 *         logger thread writes it out. This is a multiple-producer, single-consumer design: any activity calling log is acting as a producer, and
 *         the background logger thread is the consumer. If the logger thread falls behind, the BlockingQueue eventually blocks the producers until the
 *         logger thread catches up.
 */
public class LogWriter {

    private final BlockingQueue<String> queue;
    private final LoggerThread logger;
    private static final int CAPACITY = 1000;

    public LogWriter(Writer writer) {
        this.queue = new LinkedBlockingQueue<String>(CAPACITY);
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }

    private class LoggerThread extends Thread {

        private final PrintWriter writer;

        public LoggerThread(Writer writer) {
            this.writer = new PrintWriter(writer, true); // autoflush
        }

        public void run() {
            try {
                while (true)
                    writer.println(queue.take());
            } catch (InterruptedException ignored) {
            } finally {
                writer.close();
            }
        }
    }
}
