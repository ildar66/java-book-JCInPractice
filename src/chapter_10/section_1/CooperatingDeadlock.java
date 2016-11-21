package chapter_10.section_1;

import java.util.HashSet;
import java.util.Set;

import chapter_4.section_3.Point;
import net.jcip.annotations.GuardedBy;

/**
 * CooperatingDeadlock
 * <p/>
 * Lock-ordering deadlock between cooperating objects
 * @author Brian Goetz and Tim Peierls
 *         While no method explicitly acquires two locks, callers of setLocation and getImage can acquire two locks just the same. If a thread calls
 *         setLocation in response to an update from a GPS receiver, it first updates the taxi's location and then checks to see if it has reached its
 *         destination. If it has, it informs the dispatcher that it needs a new destination. Since both setLocation and notifyAvailable are
 *         synchronized, the thread calling setLocation acquires the Taxi lock and then the Dispatcher lock. Similarly, a thread calling getImage
 *         acquires the Dispatcher lock and then each Taxi lock (one at at time). Just as in LeftRightDeadlock, two locks are acquired by two threads
 *         in different orders, risking deadlock.
 */
public class CooperatingDeadlock {

    // Warning: deadlock-prone!
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

        public synchronized void setLocation(Point location) {
            this.location = location;
            if (location.equals(destination))
                dispatcher.notifyAvailable(this);
        }

        public synchronized Point getDestination() {
            return destination;
        }

        public synchronized void setDestination(Point destination) {
            this.destination = destination;
        }
    }

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

        public synchronized Image getImage() {
            Image image = new Image();
            for (Taxi t : taxis)
                image.drawMarker(t.getLocation());
            return image;
        }
    }

    class Image {

        public void drawMarker(Point p) {
        }
    }
}
