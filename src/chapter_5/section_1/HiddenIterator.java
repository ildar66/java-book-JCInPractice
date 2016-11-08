package chapter_5.section_1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.jcip.annotations.GuardedBy;

/**
 * HiddenIterator
 * <p/>
 * Iteration hidden within string concatenation
 * @author Brian Goetz and Tim Peierls
 *         The addTenThings method could throw ConcurrentModificationException, because the collection is being iterated by toString in the process
 *         of preparing the debugging message. Of course, the real problem is that HiddenIterator is not thread-safe; the HiddenIterator lock should be
 *         acquired before using set in the println call, but debugging and logging code commonly neglect to do this.
 *         
 *         The real lesson here is that the greater the distance between the state and the synchronization that guards it, the more likely that
 *         someone will forget to use proper synchronization when accessing that state. If HiddenIterator wrapped the HashSet with a synchronizedSet,
 *         encapsulating the synchronization, this sort of error would not occur.
 *         Just as encapsulating an object's state makes it easier to preserve its invariants, encapsulating its synchronization makes it easier to
 *         enforce its synchronization policy.
 *
 *         Iteration is also indirectly invoked by the collection's hashCode and equals methods, which may be called if the collection is used as an
 *         element or key of another collection. Similarly, the containsAll, removeAll, and retainAll methods, as well as the constructors that take
 *         collections are arguments, also iterate the collection. All of these indirect uses of iteration can cause ConcurrentModificationException.
 */
public class HiddenIterator {

    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<Integer>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        System.out.println("DEBUG: added ten elements to " + set);// Don't Do this.
    }

    public static void main(String[] args) {
        new HiddenIterator().addTenThings();
    }
}
