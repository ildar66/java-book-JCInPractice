package chapter_11.section_4;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * BetterAttributeStore
 * <p/>
 * Reducing lock duration
 * @author Brian Goetz and Tim Peierls
 *         Because AttributeStore has only one state variable, attributes, we can improve it further by the technique of delegating thread safety
 *         (Section 4.3). By replacing attributes with a thread-safe Map (a Hashtable, synchronizedMap, or ConcurrentHashMap), AttributeStore can
 *         delegate all its thread safety obligations to the underlying thread-safe collection. This eliminates the need for explicit synchronization
 *         in AttributeStore, reduces the lock scope to the duration of the Map access, and removes the risk that a future maintainer will undermine
 *         thread safety by forgetting to acquire the appropriate lock before accessing attributes.
 */
@ThreadSafe
public class BetterAttributeStore {

    @GuardedBy("this")
    private final Map<String, String> attributes = new HashMap<String, String>();

    public boolean userLocationMatches(String name, String regexp) {
        String key = "users." + name + ".location";
        String location;
        synchronized (this) {
            location = attributes.get(key);
        }
        if (location == null)
            return false;
        else
            return Pattern.matches(regexp, location);
    }
}
