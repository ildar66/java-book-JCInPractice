/**
 * Created by User on 30.11.2016.
 * What is a Memory Model, and Why would I Want One?
 *
 * The Java Memory Model is specified in terms of actions, which include reads and writes to variables, locks and unlocks of monitors,
 * and starting and joining with threads. The JMM defines a partial ordering called happens-before on all actions within the program.
 * To guarantee that the thread executing action B can see the results of action A (whether or not A and B occur in different threads),
 * there must be a happens-before relationship between A and B. In the absence of a happens-before ordering between two operations,
 * the JVM is free to reorder them as it pleases.
 *
 * The rules for happens-before are:

     Program order rule. Each action in a thread happens-before every action in that thread that comes later in the program order.

     Monitor lock rule. An unlock on a monitor lock happens-before every subsequent lock on that same monitor lock.[3]

     Volatile variable rule. A write to a volatile field happens-before every subsequent read of that same field.[4]

     Thread start rule. A call to Thread.start on a thread happens-before every action in the started thread.

     Thread termination rule. Any action in a thread happens-before any other thread detects that thread has terminated, either by successfully
     return from Thread.join or by Thread.isAlive returning false.

     Interruption rule. A thread calling interrupt on another thread happens-before the interrupted thread detects the interrupt
     (either by having InterruptedException tHRown, or invoking isInterrupted or interrupted).

     Finalizer rule. The end of a constructor for an object happens-before the start of the finalizer for that object.

     Transitivity. If A happens-before B, and B happens-before C, then A happens-before C.


     [3] Locks and unlocks on explicit Lock objects have the same memory semantics as intrinsic locks.

     [4] Reads and writes of atomic variables have the same memory semantics as volatile variables.


 */
package chapter_16.section_1;