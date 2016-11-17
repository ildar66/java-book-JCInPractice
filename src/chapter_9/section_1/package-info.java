/**
 * Created by User on 17.11.2016.
 *
 * The Swing single-thread rule: Swing components and models should be created, modified, and queried only from the event-dispatching thread.
 *
 * As with all rules, there are a few exceptions. A small number of Swing methods may be called safely from any thread; these are clearly identified
 * in the Javadoc as being thread-safe. Other exceptions to the single-thread rule include:

     SwingUtilities.isEventDispatchThread, which determines whether the current thread is the event thread;

     SwingUtilities.invokeLater, which schedules a Runnable for execution on the event thread (callable from any thread);

     SwingUtilities.invokeAndWait, which schedules a Runnable task for execution on the event thread and blocks the current thread until it completes
        (callable only from a non-GUI thread);

     methods to enqueue a repaint or revalidation request on the event queue (callable from any thread); and

     methods for adding and removing listeners (can be called from any thread, but listeners will always be invoked in the event thread).
 */
package chapter_9.section_1;