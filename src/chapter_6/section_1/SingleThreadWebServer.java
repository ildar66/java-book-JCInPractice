package chapter_6.section_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SingleThreadWebServer
 * <p/>
 * Sequential web server
 * @author Brian Goetz and Tim Peierls
 *         SingleThreadedWebServer is simple and theoretically correct, but would perform poorly in production because it can handle only one request
 *         at a time. The main thread alternates between accepting connections and processing the associated request. While the server is handling a
 *         request, new connections must wait until it finishes the current request and calls accept again. This might work if request processing
 *         were
 *         so fast that handleRequest effectively returned immediately, but this doesn't describe any web server in the real world.
 */

public class SingleThreadWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
