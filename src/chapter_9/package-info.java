/**
 * Created by User on 17.11.2016.
 * GUI Applications chapter.
 *
 * Consider a split-model design when a data model must be shared by more than one thread and implementing a thread-safe data model would be
 * inadvisable because of blocking, consistency, or complexity reasons.
 *
 * GUI frameworks are nearly always implemented as single-threaded subsystems in which all presentation-related code runs as tasks in an event thread.
 * Because there is only a single event thread, long-running tasks can compromise responsiveness and so should be executed in background threads.
 * Helper classes like SwingWorker or the BackgroundTask class built here, which provide support for cancellation, progress indication,
 * and completion indication, can simplify the development of long-running tasks that have both GUI and non-GUI components.

 */
package chapter_9;