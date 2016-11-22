/**
 * Created by User on 22.11.2016.
 * Reducing Lock Contention section.
 *
 * The principal threat to scalability in concurrent applications is the exclusive resource lock.
 *
 * There are three ways to reduce lock contention:

        Reduce the duration for which locks are held;

        Reduce the frequency with which locks are requested; or

        Replace exclusive locks with coordination mechanisms that permit greater concurrency.
 */

/*
    Lock splitting can sometimes be extended to partition locking on a variablesized set of independent objects,
    in which case it is called lock striping. For example, the implementation of ConcurrentHashMap uses an array of 16 locks,
    each of which guards 1/16 of the hash buckets; bucket N is guarded by lock N mod 16. Assuming the hash function provides reasonable spreading
    characteristics and keys are accessed uniformly, this should reduce the demand for any given lock by approximately a factor of 16.
    It is this technique that enables ConcurrentHashMap to support up to 16 concurrent writers.
    (The number of locks could be increased to provide even better concurrency under heavy access on high-processor-count systems,
     but the number of stripes should be increased beyond the default of 16 only when you have evidence that concurrent writers are generating
     enough contention to warrant raising the limit.)

    One of the downsides of lock striping is that locking the collection for exclusive access is more difficult and costly than with a single lock.
    Usually an operation can be performed by acquiring at most one lock, but occasionally you need to lock the entire collection,
    as when ConcurrentHashMap needs to expand the map and rehash the values into a larger set of buckets.
    This is typically done by acquiring all of the locks in the stripe set.

 */
package chapter_11.section_4;