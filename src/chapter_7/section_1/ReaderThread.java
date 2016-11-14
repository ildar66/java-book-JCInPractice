package chapter_7.section_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * ReaderThread
 * <p/>
 * Encapsulating nonstandard cancellation in a Thread by overriding interrupt
 * Many blocking library methods respond to interruption by returning early and throwing InterruptedException, which makes it easier to build tasks that are responsive to cancellation. However, not all blocking methods or blocking mechanisms are responsive to interruption; if a thread is blocked performing synchronous socket I/O or waiting to acquire an intrinsic lock, interruption has no effect other than setting the thread's interrupted status. We can sometimes convince threads blocked in noninterruptible activities to stop by means similar to interruption, but this requires greater awareness of why the thread is blocked.

        Synchronous socket I/O in java.io. The common form of blocking I/O in server applications is reading or writing to a socket. Unfortunately, the read and write methods in InputStream and OutputStream are not responsive to interruption, but closing the underlying socket makes any threads blocked in read or write throw a SocketException.

        Synchronous I/O in java.nio. Interrupting a thread waiting on an InterruptibleChannel causes it to throw ClosedByInterruptException and close the channel (and also causes all other threads blocked on the channel to throw ClosedByInterruptException). Closing an InterruptibleChannel causes threads blocked on channel operations to throw AsynchronousCloseException. Most standard Channels implement InterruptibleChannel.

        Asynchronous I/O with Selector. If a thread is blocked in Selector.select (in java.nio.channels), wakeup causes it to return prematurely by throwing a ClosedSelectorException.

        Lock acquisition. If a thread is blocked waiting for an intrinsic lock, there is nothing you can do to stop it short of ensuring that it eventually acquires the lock and makes enough progress that you can get its attention some other way. However, the explicit Lock classes offer the lockInterruptibly method, which allows you to wait for a lock and still be responsive to interruptssee Chapter 13.


 * @author Brian Goetz and Tim Peierls
 *         ReaderThread shows a technique for encapsulating nonstandard cancellation. ReaderThread manages a single socket connection,
 *         reading synchronously from the socket and passing any data received to processBuffer. To facilitate terminating a user connection or
 *         shutting down the server, ReaderThread overrides interrupt to both deliver a standard interrupt and close the underlying socket; thus
 *         interrupting a ReaderThread makes it stop what it is doing whether it is blocked in read or in an interruptible blocking method.
 */
public class ReaderThread extends Thread {

    private static final int BUFSZ = 512;
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try {
            socket.close();
        } catch (IOException ignored) {
        } finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFSZ];
            while (true) {
                int count = in.read(buf);
                if (count < 0)
                    break;
                else if (count > 0)
                    processBuffer(buf, count);
            }
        } catch (IOException e) {
            /* Allow thread to exit */
        }
    }

    public void processBuffer(byte[] buf, int count) {
    }
}
