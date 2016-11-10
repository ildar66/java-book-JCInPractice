package chapter_5.section_6;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Memoizer2
 * <p/>
 * Replacing HashMap with ConcurrentHashMap
 * @author Brian Goetz and Tim Peierls
 *         Memoizer2 improves on the awful concurrent behavior of Memoizer1 by replacing the HashMap with a ConcurrentHashMap. Since
 *         ConcurrentHashMap is thread-safe, there is no need to synchronize when accessing the backing Map, thus eliminating the serialization
 *         induced by synchronizing compute in @see {@link Memoizer1}.
 *
 *         Memoizer2 certainly has better concurrent behavior than @see {@link Memoizer1}: multiple threads can actually use it concurrently.
 *         But it still has some defects as a cachethere is a window of vulnerability in which two threads calling compute at the same time could end
 *         up computing the same value. In the case of memoization, this is merely inefficientthe purpose of a cache is to prevent the same data
 *         from being calculated multiple times. For a more general-purpose caching mechanism, it is far worse; for an object cache that is supposed
 *         to provide once-and-only-once initialization, this vulnerability would also pose a safety risk.
 *
 *         The problem with Memoizer2 is that if one thread starts an expensive computation, other threads are not aware that the computation is in
 *         progress and so may start the same computation.
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
