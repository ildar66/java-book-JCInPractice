package chapter_4.section_3;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * VisualComponent(Independent State Variables)
 * <p/>
 * Delegating thread safety to multiple underlying state variables
 * @author Brian Goetz and Tim Peierls
 *         VisualComponent is a graphical component that allows clients to register listeners for mouse and keystroke events. It
 *         maintains a list of registered listeners of each type, so that when an event occurs the appropriate listeners can be invoked. But there is
 *         no relationship between the set of mouse listeners and key listeners; the two are independent, and therefore VisualComponent can delegate
 *         its thread safety obligations to two underlying thread-safe lists.
 */
public class VisualComponent {

    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<KeyListener>();
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<MouseListener>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }
}
