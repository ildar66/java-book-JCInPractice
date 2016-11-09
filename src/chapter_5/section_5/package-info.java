/**
 * Created by User on 09.11.2016.
 * Synchronizers section.
 *
 * Blocking queues are unique among the collections classes: not only do they act as containers for objects, but they can also coordinate the control
 * flow of producer and consumer threads because take and put block until the queue enters the desired state (not empty or not full).
 *
 * A synchronizer is any object that coordinates the control flow of threads based on its state. Blocking queues can act as synchronizers; other types
 * of synchronizers include semaphores, barriers, and latches. There are a number of synchronizer classes in the platform library; if these do not
 * meet your needs, you can also create your own using the mechanisms described in Chapter 14.
 * 
 * All synchronizers share certain structural properties: they encapsulate state that determines whether threads arriving at the synchronizer should
 * be allowed to pass or forced to wait, provide methods to manipulate that state, and provide methods to wait efficiently for the synchronizer to
 * enter the desired state.
 */
package chapter_5.section_5;