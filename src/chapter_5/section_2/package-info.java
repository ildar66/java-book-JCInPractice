/**
 * Created by User on 08.11.2016.
 * Concurrent Collections section.
 *
 * Java 5.0 improves on the synchronized collections by providing several concurrent collection classes. Synchronized collections achieve their thread
 * safety by serializing all access to the collection's state. The cost of this approach is poor concurrency; when multiple threads contend for the
 * collection-wide lock, throughput suffers.
 *
 * The concurrent collections, on the other hand, are designed for concurrent access from multiple threads. Java 5.0 adds ConcurrentHashMap, a
 * replacement for synchronized hash-based Map implementations, and CopyOnWriteArrayList, a replacement for synchronized List implementations for
 * cases where traversal is the dominant operation. The new ConcurrentMap interface adds support for common compound actions such as put-if-absent,
 * replace, and conditional remove.
 *
 * Replacing synchronized collections with concurrent collections can offer dramatic scalability improvements with little risk.
 *
 * Java 5.0 also adds two new collection types, Queue and BlockingQueue. A Queue is intended to hold a set of elements temporarily while they
 * await processing. Several implementations are provided, including ConcurrentLinkedQueue, a traditional FIFO queue, and PriorityQueue,
 * a (non concurrent) priority ordered queue. Queue operations do not block; if the queue is empty, the retrieval operation returns null.
 * While you can simulate the behavior of a Queue with a Listin fact, LinkedList also implements Queuethe Queue classes were added because
 * eliminating the random-access requirements of List admits more efficient concurrent implementations.

 * BlockingQueue extends Queue to add blocking insertion and retrieval operations. If the queue is empty, a retrieval blocks until an element
 * is available, and if the queue is full (for bounded queues) an insertion blocks until there is space available.
 * Blocking queues are extremely useful in producer-consumer designs, and are covered in greater detail in Section 5.3.

 * Just as ConcurrentHashMap is a concurrent replacement for a synchronized hash-based Map, Java 6 adds ConcurrentSkipListMap and ConcurrentSkipListSet,
 * which are concurrent replacements for a synchronized SortedMap or SortedSet (such as TheeMap or TheeSet wrapped with synchronizedMap).
 */
package chapter_5.section_2;