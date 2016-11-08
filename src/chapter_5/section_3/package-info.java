/**
 * Created by User on 08.11.2016.
 * Blocking Queues and the Producer-consumer Pattern section.
 *
 * Blocking queues provide blocking put and take methods as well as the timed equivalents offer and poll. If the queue is full, put blocks until space
 * becomes available; if the queue is empty, take blocks until an element is available. Queues can be bounded or unbounded; unbounded queues are never
 * full, so a put on an unbounded queue never blocks.
 *
 * Blocking queues support the producer-consumer design pattern. A producerconsumer design separates the identification of work to be done from the
 * execution of that work by placing work items on a "to do" list for later processing, rather than processing them immediately as they are
 * identified. The producerconsumer pattern simplifies development because it removes code dependencies between producer and consumer classes, and
 * simplifies workload management by decoupling activities that may produce or consume data at different or variable rates.
 *
 * Bounded queues are a powerful resource management tool for building reliable applications: they make your program more robust to overload by
 * throttling activities that threaten to produce more work than can be handled.
 *
 * The class library contains several implementations of BlockingQueue. LinkedBlockingQueue and ArrayBlockingQueue are FIFO queues,
 * analogous to LinkedList and ArrayList but with better concurrent performance than a synchronized List. PriorityBlockingQueue is a
 * priority-ordered queue, which is useful when you want to process elements in an order other than FIFO. Just like other sorted collections,
 * PriorityBlockingQueue can compare elements according to their natural order (if they implement Comparable) or using a Comparator.

 The last BlockingQueue implementation, SynchronousQueue, is not really a queue at all, in that it maintains no storage space for queued elements.
 Instead, it maintains a list of queued threads waiting to enqueue or dequeue an element. In the dish-washing analogy, this would be like having
 no dish rack, but instead handing the washed dishes directly to the next available dryer. While this may seem a strange way to implement a queue,
 it reduces the latency associated with moving data from producer to consumer because the work can be handed off directly.
 (In a traditional queue, the enqueue and dequeue operations must complete sequentially before a unit of work can be handed off.)
 The direct handoff also feeds back more information about the state of the task to the producer; when the handoff is accepted,
 it knows a consumer has taken responsibility for it, rather than simply letting it sit on a queue somewheremuch like the difference between
 handing a document to a colleague and merely putting it in her mailbox and hoping she gets it soon. Since a SynchronousQueue has no storage capacity,
 put and take will block unless another thread is already waiting to participate in the handoff.
 */
package chapter_5.section_3;