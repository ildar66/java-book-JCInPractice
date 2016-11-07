package chapter_4.section_3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * NumberRange
 * <p/>
 * Number range class that does not sufficiently protect its invariants
 * @author Brian Goetz and Tim Peierls
 *         NumberRange is not thread-safe; it does not preserve the invariant that constrains lower and upper. The setLower and setUpper methods
 *         attempt to respect this invariant, but do so poorly. Both setLower and setUpper are check-then-act sequences, but they do not use
 *         sufficient locking to make them atomic.
 *
 *         If the number range holds (0, 10), and one thread calls setLower(5) while another thread calls setUpper(4), with some unlucky timing
 *         both will pass the checks in the setters and both modifications will be applied. The result is that the range now holds (5, 4)an invalid state.
 *         So while the underlying AtomicIntegers are thread-safe, the composite class is not.
 *
 *         Because the underlying state variables lower and upper are not independent, NumberRange cannot simply delegate thread safety
 *         to its thread-safe state varaibles.
 */

public class NumberRange {

    // INVARIANT: lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // Warning -- unsafe check-then-act
        if (i > upper.get())
            throw new IllegalArgumentException("can't set lower to " + i
                                                       + " > upper");
        lower.set(i);
    }

    public void setUpper(int i) {
        // Warning -- unsafe check-then-act
        if (i < lower.get())
            throw new IllegalArgumentException("can't set upper to " + i
                                                       + " < lower");
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
