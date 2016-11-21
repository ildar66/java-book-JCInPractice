package chapter_10.section_1;

import java.util.HashSet;
import java.util.Set;

import chapter_4.section_3.Point;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * CooperatingNoDeadlock
 * <p/>
 * Using open calls to avoiding deadlock between cooperating objects
 * @author Brian Goetz and Tim Peierls
 *         Restructuring a synchronized block to allow open calls can sometimes have undesirable consequences, since it takes an operation that was
 *         atomic and makes it not atomic. In many cases, the loss of atomicity is perfectly acceptable; there's no reason that updating a taxi's
 *         location and notifying the dispatcher that it is ready for a new destination need be an atomic operation. In other cases, the loss of
 *         atomicity is noticeable but the semantic changes are still acceptable. In the deadlock-prone version, getImage produces a complete
 *         snapshot of the fleet locations at that instant; in the refactored version, it fetches the location of each taxi at slightly different
 *         times.
 */
class CooperatingNoDeadlock {

    @ThreadSafe
    class Taxi {

        @GuardedBy("this")
        private Point location, destination;
        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation() {
            return location;
        }

        public void setLocation(Point location) {
            boolean reachedDestination;
            synchronized (this) {
                this.location = location;
                reachedDestination = location.equals(destination);
            }
            if (reachedDestination)
                dispatcher.notifyAvailable(this);
        }

        public synchronized Point getDestination() {
            return destination;
        }

        public synchronized void setDestination(Point destination) {
            this.destination = destination;
        }
    }

    @ThreadSafe
    class Dispatcher {

        @GuardedBy("this")
        private final Set<Taxi> taxis;
        @GuardedBy("this")
        private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            taxis = new HashSet<Taxi>();
            availableTaxis = new HashSet<Taxi>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }

        public Image getImage() {
            Set<Taxi> copy;
            synchronized (this) {
                copy = new HashSet<Taxi>(taxis);
            }
            Image image = new Image();
            for (Taxi t : copy)
                image.drawMarker(t.getLocation());
            return image;
        }
    }

    class Image {

        public void drawMarker(Point p) {
        }
    }

}