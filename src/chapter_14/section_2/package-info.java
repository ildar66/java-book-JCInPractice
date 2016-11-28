/**
 * Created by User on 25.11.2016.
 * Using Condition Queues section.
 *
 * Document the condition predicate(s) associated with a condition queue and the operations that wait on them.
 *
 * Every call to wait is implicitly associated with a specific condition predicate. When calling wait regarding a particular condition predicate, the
 * caller must already hold the lock associated with the condition queue, and that lock must also guard the state variables from which the condition
 * predicate is composed.
 *
 * When using condition waits (Object.wait or Condition.await):

     Always have a condition predicatesome test of object state that must hold before proceeding;

     Always test the condition predicate before calling wait, and again after returning from wait;

     Always call wait in a loop;

     Ensure that the state variables making up the condition predicate are guarded by the lock associated with the condition queue;

     Hold the lock associated with the the condition queue when calling wait, notify, or notifyAll; and

     Do not release the lock after checking the condition predicate but before acting on it.
 */
/*
    Single notify can be used instead of notifyAll only when both of the following conditions hold:
        Uniform waiters. Only one condition predicate is associated with the condition queue, and each thread executes the same logic upon returning from wait; and
        One-in, one-out. A notification on the condition variable enables at most one thread to proceed.
**/
package chapter_14.section_2;