/**
 * Created by User on 02.11.2016.
 * Sharing Objects
 *
 * Locking and Visibility:
 *
 * When thread A executes a synchronized block, and subsequently thread B enters a synchronized block guarded by the same lock, the values of
 * variables that were visible to A prior to releasing the lock are guaranteed to be visible to B upon acquiring the lock. In other words,
 * everything A did in or prior to a synchronized block is visible to B when it executes a synchronized block guarded by the same lock.
 * Without synchronization, there is no such guarantee.
 *
 * Locking is not just about mutual exclusion; it is also about memory visibility. To ensure that all threads see the most up-to-date values of shared
 * mutable variables, the reading and writing threads must synchronize on a common lock.
 *
 * 
 * Mutable Objects:
     If an object may be modified after construction, safe publication ensures only the visibility of the as-published state.
        Synchronization must be used not only to publish a mutable object, but also every time the object is accessed to ensure visibility
        of subsequent modifications. To share mutable objects safely, they must be safely published and be either thread-safe or guarded by a lock.

     The publication requirements for an object depend on its mutability:

     Immutable objects can be published through any mechanism;

     Effectively immutable objects must be safely published;

     Mutable objects must be safely published, and must be either threadsafe or guarded by a lock.
 */
/*
Sharing Objects Safely
        Whenever you acquire a reference to an object, you should know what you are allowed to do with it.
        Do you need to acquire a lock before using it? Are you allowed to modify its state, or only to read it?
        Many concurrency errors stem from failing to understand these "rules of engagement" for a shared object.
        When you publish an object, you should document how the object can be accessed.

        The most useful policies for using and sharing objects in a concurrent program are:

            Thread-confined. A thread-confined object is owned exclusively by and confined to one thread, and can be modifled by its owning thread.

            Shared read-only. A shared read-only object can be accessed concurrently by multiple threads without additional synchronization,
            but cannot be modified by any thread. Shared read-only objects include immutable and effectively immutable objects.

            Shared thread-safe. A thread-safe object performs synchronization internally, so multiple threads can freely access it through
            its public interface without further synchronization.

            Guarded. A guarded object can be accessed only with a specific lock held. Guarded objects include those that are encapsulated
            within other thread-safe objects and published objects that are known to be guarded by a specific lock.
*/
        package chapter_3;