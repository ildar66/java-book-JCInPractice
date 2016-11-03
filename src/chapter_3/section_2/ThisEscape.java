package chapter_3.section_2;

/**
 * ThisEscape
 * <p/>
 * Implicitly allowing the this reference to escape
 * @author Brian Goetz and Tim Peierls
 *         When ThisEscape publishes the EventListener, it implicitly publishes the enclosing ThisEscape instance as well, because inner class
 *         instances contain a hidden reference to the enclosing instance.
 * @see SafeListener
 */
public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {

            public void onEvent(Event e) {
                doSomething(e);
            }
        });
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
