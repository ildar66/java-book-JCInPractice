package chapter_14.section_1;

import chapter_12.section_1.BaseBoundedBuffer;
import net.jcip.annotations.ThreadSafe;

/**
 * GrumpyBoundedBuffer
 * <p/>
 * Bounded buffer that balks when preconditions are not met
 * @author Brian Goetz and Tim Peierls
 *         GrumpyBoundedBuffer is a crude first attempt at implementing a bounded buffer. The put and take methods are synchronized to
 *         ensure exclusive access to the buffer state, since both employ check-then-act logic in accessing the buffer.
 *         While this approach is easy enough to implement, it is annoying to use. Exceptions are supposed to be for exceptional conditions [EJ Item
 *         39]. "Buffer is full" is not an exceptional condition for a bounded buffer any more than "red" is an exceptional condition for a traffic
 *         signal. The simplification in implementing the buffer (forcing the caller to manage the state dependence) is more than made up for by the
 *         substantial complication in using it, since now the caller must be prepared to catch exceptions and possibly retry for every buffer
 *         operation.[1] A well-structured call to take is shown in Listing 14.4not very pretty, especially if put and take are called throughout the
 *         program.
 *         [1] Pushing the state dependence back to the caller also makes it nearly impossible to do things like preserve FIFO ordering; by forcing
 *         the caller to retry, you lose the information of who arrived first
 */
@ThreadSafe
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public GrumpyBoundedBuffer() {
        this(100);
    }

    public GrumpyBoundedBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull())
            throw new BufferFullException();
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty())
            throw new BufferEmptyException();
        return doTake();
    }
}

class ExampleUsage {

    private GrumpyBoundedBuffer<String> buffer;
    int SLEEP_GRANULARITY = 50;

    void useBuffer() throws InterruptedException {
        while (true) {
            try {
                String item = buffer.take();
                // use item
                break;
            } catch (BufferEmptyException e) {
                Thread.sleep(SLEEP_GRANULARITY);
            }
        }
    }
}

class BufferFullException extends RuntimeException {

}

class BufferEmptyException extends RuntimeException {

}
