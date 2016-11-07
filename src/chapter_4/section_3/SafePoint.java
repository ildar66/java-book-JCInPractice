package chapter_4.section_3;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * SafePoint
 * @author Brian Goetz and Tim Peierls
 *         SafePoint provides a getter that retrieves both the x and y values at once by returning a two-element array. If we
 *         provided separate getters for x and y, then the values could change between the time one coordinate is retrieved and the other, resulting
 *         in a caller seeing an inconsistent value: an (x, y) location where the vehicle never was. Using SafePoint, we can construct a vehicle
 *         tracker that publishes the underlying mutable state without undermining thread safety, as shown in the @see {@link
 *         PublishingVehicleTracker}
 *         The private constructor exists to avoid the race condition that would occur if the copy constructor were implemented as this(p.x, p.y);
 *         this is an example of the private constructor capture idiom (Bloch and Gafter, 2005).
 */
@ThreadSafe
public class SafePoint {

    @GuardedBy("this")
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.set(x, y);
    }

    public synchronized int[] get() {
        return new int[] {x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
