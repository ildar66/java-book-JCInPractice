package chapter_3.section_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionDispenser
 * <p/>
 * Using ThreadLocal to ensure thread confinement
 * @author Brian Goetz and Tim Peierls
 *         A more formal means of maintaining thread confinement is ThreadLocal, which allows you to associate a per-thread value with a
 *         value-holding object. Thread-Local provides get and set accessormethods that maintain a separate copy of the value for each thread
 *         that uses it, so a get returns the most recent value passed to set from the currently executing thread.
 *
 *         When a thread calls ThreadLocal.get for the first time, initialValue is consulted to provide the initial value for that thread.
 *         
 *         Conceptually, you can think of a ThreadLocal<T> as holding a Map<Thread,T> that stores the thread-specific values, though this is not how
 *         it is actually implemented. The thread-specific values are stored in the Thread object itself; when the thread terminates, the
 *         thread-specific values can be garbage collected.
 */
public class ConnectionDispenser {

    static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {

        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to acquire Connection, e");
            }
        }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
