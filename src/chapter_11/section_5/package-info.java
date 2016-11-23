/**
 * Created by User on 23.11.2016.
 * Example: Comparing Map Performance
 *
 * The single-threaded performance of ConcurrentHashMap is slightly better than that of a synchronized HashMap, but it is in concurrent use that it
 * really shines. The implementation of ConcurrentHashMap assumes the most common operation is retrieving a value that already exists, and is
 * therefore optimized to provide highest performance and concurrency for successful get operations.
 * 
 * The major scalability impediment for the synchronized Map implementations is that there is a single lock for the entire map, so only one thread can
 * access the map at a time. On the other hand, ConcurrentHashMap does no locking for most successful read operations, and uses lock striping for
 * write operations and those few read operations that do require locking. As a result, multiple threads can access the Map concurrently without
 * blocking.
 */
package chapter_11.section_5;