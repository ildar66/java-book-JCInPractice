/**
 * Created by User on 15.11.2016.
 * Handling Abnormal Thread Termination section.
 *
 * In long-running applications, always use uncaught exception handlers for all threads that at least log the exception.
 *
 * To set an UncaughtExceptionHandler for pool threads, provide a THReadFactory to the ThreadPoolExecutor constructor. (As with all thread
 * manipulation, only the thread's owner should change its UncaughtExceptionHandler.) The standard thread pools allow an uncaught task exception to
 * terminate the pool thread, but use a try-finally block to be notified when this happens so the thread can be replaced. Without an uncaught
 * exception handler or other failure notification mechanism, tasks can appear to fail silently, which can be very confusing. If you want to be
 * notified when a task fails due to an exception so that you can take some task-specific recovery action, either wrap the task with a Runnable or
 * Callable that catches the exception or override the afterExecute hook in THReadPoolExecutor.
 * 
 * Somewhat confusingly, exceptions thrown from tasks make it to the uncaught exception handler only for tasks submitted with execute; for tasks
 * submitted with submit, any thrown exception, checked or not, is considered to be part of the task's return status. If a task submitted with submit
 * terminates with an exception, it is rethrown by Future.get, wrapped in an ExecutionException.
 */
package chapter_7.section_3;