package chapter_3.section_5;

/**
 * Holder
 * <p/>
 * Class at risk of failure if not properly published
 * @author Brian Goetz and Tim Peierls
 *         However, Holder can be made immune to improper publication by declaring the n field to be final, which would make Holder immutable
 */
public class Holder {

    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}
/*
The internal synchronization in thread-safe collections means that placing an object in a thread-safe collection, such as a Vector or synchronizedList, fulfills the last of these requirements. If thread A places object X in a thread-safe collection and thread B subsequently retrieves it, B is guaranteed to see the state of X as A left it, even though the application code that hands X off in this manner has no explicit synchronization. The thread-safe library collections offer the following safe publication guarantees, even if the Javadoc is less than clear on the subject:

        Placing a key or value in a Hashtable, synchronizedMap, or Concurrent-Map safely publishes it to any thread that retrieves it from the Map (whether directly or via an iterator);

        Placing an element in a Vector, CopyOnWriteArrayList, CopyOnWrite-ArraySet, synchronizedList, or synchronizedSet safely publishes it to any thread that retrieves it from the collection;

        Placing an element on a BlockingQueue or a ConcurrentLinkedQueue safely publishes it to any thread that retrieves it from the queue.

        Other handoff mechanisms in the class library (such as Future and Exchanger) also constitute safe publication; we will identify these as providing safe publication as they are introduced.

        Using a static initializer is often the easiest and safest way to publish objects that can be statically constructed:

        public static Holder holder = new Holder(42);



        Static initializers are executed by the JVM at class initialization time; because of internal synchronization in the JVM, this mechanism is guaranteed to safely publish any objects initialized in this way [JLS
*/