package chapter_16.section_3;

import java.util.HashMap;
import java.util.Map;

import net.jcip.annotations.ThreadSafe;

/**
 * SafeStates
 * <p/>
 * Initialization safety for immutable objects
 * @author Brian Goetz and Tim Peierls
 *         Initialization safety means that SafeStates could be safely published even through unsafe lazy initialization or stashing a
 *         reference to a SafeStates in a public static field with no synchronization, even though it uses no synchronization and relies on the
 *         non-thread-safe HashSet.
 */
@ThreadSafe
public class SafeStates {

    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<String, String>();
        states.put("alaska", "AK");
        states.put("alabama", "AL");
        /* ... */
        states.put("wyoming", "WY");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
