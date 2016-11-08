package chapter_4.section_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

/**
 * ListHelder
 * <p/>
 * Examples of thread-safe and non-thread-safe implementations of put-if-absent
 * helper methods for List
 * @author Brian Goetz and Tim Peierls
 *         The documentation for Vector and the synchronized wrapper classes states, albeit obliquely, that they support client-side locking, by
 *         using the intrinsic lock for the Vector or the wrapper collection (not the wrapped collection).
 *
 *         If extending a class to add another atomic operation is fragile because it distributes the locking code for a class over multiple classes
 *         in an object hierarchy, client-side locking is even more fragile because it entails putting locking code for class C into classes that are
 *         totally unrelated to C. Exercise care when using client-side locking on classes that do not commit to their locking strategy.
 *
 *         Client-side locking has a lot in common with class extensionthey both couple the behavior of the derived class to the implementation of
 *         the base class. Just as extension violates encapsulation of implementation [EJ Item 14], client-side locking violates encapsulation of
 *         synchronization policy.
 */

@NotThreadSafe
class BadListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent)
            list.add(x);
        return absent;
    }
}

@ThreadSafe
class GoodListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent)
                list.add(x);
            return absent;
        }
    }
}
