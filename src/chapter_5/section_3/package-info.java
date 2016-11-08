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
 */
package chapter_5.section_3;