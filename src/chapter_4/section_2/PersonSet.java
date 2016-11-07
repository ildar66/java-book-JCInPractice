package chapter_4.section_2;

import java.util.HashSet;
import java.util.Set;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * PersonSet
 * <p/>
 * Using confinement to ensure thread safety
 * @author Brian Goetz and Tim Peierls
 *         PersonSet illustrates how confinement and locking can work together to make a class thread-safe even when its component
 *         state variables are not. The state of PersonSet is managed by a HashSet, which is not thread-safe. But because mySet is private and not
 *         allowed to escape, the HashSet is confined to the PersonSet. The only code paths that can access mySet are addPerson and containsPerson,
 *         and each of these acquires the lock on the PersonSet. All its state is guarded by its intrinsic lock, making PersonSet thread-safe.
 */

@ThreadSafe
public class PersonSet {

    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {

    }
}
