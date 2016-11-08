package chapter_5.section_1;

import java.util.Vector;

/**
 * SafeVectorHelpers
 * <p/>
 * Compound actions on Vector using client-side locking
 * @author Brian Goetz and Tim Peierls
 */
public class SafeVectorHelpers {

    public static Object getLast(Vector<?> list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector<?> list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }

/*    // Iteration that may Throw ArrayIndexOutOfBoundsException.
    for (int i = 0; i < vector.size()i++)
        doSomething(vector.get(i))

    // Iteration with Client-side Locking.
    synchronized (vector) {
        for (int i = 0; i < vector.size(); i++)
            doSomething(vector.get(i));
    }*/

}
