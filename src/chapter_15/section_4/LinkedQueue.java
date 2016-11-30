package chapter_15.section_4;

import java.util.concurrent.atomic.AtomicReference;

import net.jcip.annotations.ThreadSafe;

/**
 * LinkedQueue.
 * <p/>
 * Insertion in the Michael-Scott nonblocking queue algorithm
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class LinkedQueue<E> {

    private static class Node<E> {

        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    private final Node<E> dummy = new Node<E>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> tailNext = curTail.next.get();
            if (curTail == tail.get()) {
                if (tailNext != null) {
                    // Queue in intermediate state, advance tail
                    tail.compareAndSet(curTail, tailNext);
                } else {
                    // In quiescent state, try inserting new node
                    if (curTail.next.compareAndSet(null, newNode)) {
                        // Insertion succeeded, try advancing tail
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }
                }
            }
        }
    }

    // my get method:
    public E get() {
        while (true) {
            Node<E> curHead = head.get();
            Node<E> headNext = curHead.next.get();
            // test: is head changed?(if changed, try again)
            if (curHead == head.get()) {
                if (headNext != null) {
                    if (head.compareAndSet(curHead, headNext)) {
                        return headNext.item;
                    }
                } else {
                    // head == dummy
                    return null;
                }
            }
        }
    }
}
