package chapter_4.section_3;

import java.awt.Point;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.jcip.annotations.ThreadSafe;

/**
 * DelegatingVehicleTracker
 * <p/>
 * Delegating thread safety to a ConcurrentHashMap
 * @author Brian Goetz and Tim Peierls
 *         DelegatingVehicleTracker does not use any explicit synchronization; all access to state is managed by ConcurrentHashMap, and
 *         all the keys and values of the Map are immutable.
 *
 *         If we had used the original MutablePoint class instead of Point, we would be breaking encapsulation by letting getLocations publish a
 *         reference to mutable state that is not thread-safe. Notice that we've changed the behavior of the vehicle tracker class slightly; while the
 *         monitor version returned a snapshot of the locations, the delegating version returns an unmodifiable but "live" view of the vehicle
 *         locations. This means that if thread A calls getLocations and thread B later modifies the location of some of the points, those changes are
 *         reflected in the Map returned to thread A. As we remarked earlier, this can be a benefit (more up-to-date data) or a liability (potentially
 *         inconsistent view of the fleet), depending on your requirements.
 *         
 *         If an unchanging view of the fleet is required, getLocations could instead return a shallow copy of the locations map. Since the contents
 *         of the Map are immutable, only the structure of the Map, not the contents, must be copied, as shown in Listing 4.8 (which returns a plain
 *         HashMap, since getLocations did not promise to return a thread-safe Map).
 */
@ThreadSafe
public class DelegatingVehicleTracker {

    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<String, Point>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null)
            throw new IllegalArgumentException("invalid vehicle name: " + id);
    }

    // Alternate version of getLocations (Listing 4.8)
    public Map<String, Point> getLocationsAsStatic() {
        return Collections
                .unmodifiableMap(new HashMap<String, Point>(locations));
    }
}
