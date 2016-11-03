package chapter_3.section_2;

/**
 * SafeListener
 * <p/>
 * Using a factory method to prevent the this reference from escaping during
 * construction
 * @author Brian Goetz and Tim Peierls
 *         @see ThisEscape illustrates an important special case of escapewhen the this references escapes during construction. When the inner
 *         EventListener instance is published, so is the enclosing ThisEscape instance. But an object is in a predictable, consistent state only
 *         after its constructor returns, so publishing an object from within its constructor can publish an incompletely constructed object. This is
 *         true even if the publication is the last statement in the constructor. If the this reference escapes during construction, the object is
 *         considered not properly constructed.
 *
 * Do not allow the this reference to escape during construction.
 */
public class SafeListener {

    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {

            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {
    }

    interface EventSource {

        void registerListener(EventListener e);
    }

    interface EventListener {

        void onEvent(Event e);
    }

    interface Event {

    }
}
