package chapter_6.section_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ThreadPerTaskWebServer
 * <p/>
 * Web server that starts a new thread for each request
 * @author Brian Goetz and Tim Peierls
 *
 * A more responsive approach(@see {@link SingleThreadWebServer}) is to create a new thread for servicing each request.
 *
 * THReadPerTaskWebServer is similar in structure to the single-threaded versionthe main thread still alternates between accepting an
 * incoming connection and dispatching the request. The difference is that for each connection, the main loop creates a new thread to process
 * the request instead of processing it within the main thread.
 *
 * This has three main consequences:

            Task processing is offloaded from the main thread, enabling the main loop to resume waiting for the next incoming connection more quickly.
            This enables new connections to be accepted before previous requests complete, improving responsiveness.

            Tasks can be processed in parallel, enabling multiple requests to be serviced simultaneously.
            This may improve throughput if there are multiple processors, or if tasks need to block for any reason such as I/O completion,
            lock acquisition, or resource availability.

            Task-handling code must be thread-safe, because it may be invoked concurrently for multiple tasks.

 * Under light to moderate load, the thread-per-task approach is an improvement over sequential execution. As long as the request arrival rate does not exceed the server's capacity to handle requests, this approach offers better responsiveness and throughput.


 */
public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {

                public void run() {
                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
