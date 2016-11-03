package chapter_3.section_1;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {

        public void run() {
            // System.out.println("first read = " + number);
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        // Thread.sleep(1);
        number = 42;
        ready = true;
    }
}
