/**
 * Created by User on 09.11.2016.
 * Blocking and Interruptible Methods section.
 *
 * When your code calls a method that throws InterruptedException, then your method is a blocking method too, and must have a plan for responding to
 * interruption. For library code, there are basically two choices:
     *  Propagate the InterruptedException. This is often the most sensible policy if you can get away with itjust propagate the InterruptedException to
        your caller. This could involve not catching InterruptedException, or catching it and throwing it again after performing some brief
        activity-specific cleanup.

     *  Restore the interrupt. Sometimes you cannot throw InterruptedException, for instance when your code is part of a Runnable. In these situations, you
        must catch InterruptedException and restore the interrupted status by calling interrupt on the current thread, so that code higher up the call
        stack can see that an interrupt was issued, as demonstrated in Listing 5.10.
 *
    You can get much more sophisticated with interruption, but these two approaches should work in the vast majority of situations.
    But there is one thing you should not do with InterruptedExceptioncatch it and do nothing in response.
    This deprives code higher up on the call stack of the opportunity to act on the interruption, because the evidence that the thread was interrupted
    is lost. The only situation in which it is acceptable to swallow an interrupt is when you are extending Thread and therefore control all the codehigher
    up on the call stack.
*/
package chapter_5.section_4;
