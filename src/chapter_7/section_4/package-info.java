/**
 * Created by User on 15.11.2016.
 * JVM Shutdown section.
 *
 * The JVM can shut down in either an orderly or abrupt manner. An orderly shutdown is initiated when the last "normal" (nondaemon) thread
 * terminates, someone calls System.exit, or by other platform-specific means (such as sending a SIGINT or hitting Ctrl-C).
 * While this is the standard and preferred way for the JVM to shut down, it can also be shut down abruptly by calling Runtime.halt or by killing the
 * JVM process through the operating system (such as sending a SIGKILL).
 *
 * Daemon threads are not a good substitute for properly managing the lifecycle of services within an application.
 *
 * Avoid finalizers.
 */
package chapter_7.section_4;