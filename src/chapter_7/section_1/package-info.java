/**
 * Created by User on 11.11.2016.
 * Cancellation and Shutdown section.
 *
 * An activity is cancellable if external code can move it to completion before its normal completion.
 * There are a number of reasons why you might want to cancel an activity:
 *
 * User-requested cancellation. The user clicked on the "cancel" button in a GUI application, or requested cancellation through a management
 * interface such as JMX (Java Management Extensions).
 *
 * Time-limited activities. An application searches a problem space for a finite amount of time and chooses the best solution found within that time.
 * When the timer expires, any tasks still searching are cancelled.
 *
 * Application events. An application searches a problem space by decomposing it so that different tasks search different regions of the problem
 * space. When one task finds a solution, all other tasks still searching are cancelled.
 *
 * Errors. A web crawler searches for relevant pages, storing pages or summary data to disk. When a crawler task encounters an error (for example,
 * the disk is full), other crawling tasks are cancelled, possibly recording their current state so that they can be restarted later.
 *
 * Shutdown. When an application or service is shut down, something must be done about work that is currently being processed or queued for
 * processing. In a graceful shutdown, tasks currently in progress might be allowed to complete; in a more immediate shutdown, currently executing
 * tasks might be cancelled.
 */
package chapter_7.section_1;