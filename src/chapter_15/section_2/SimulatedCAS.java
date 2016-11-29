package chapter_15.section_2;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * SimulatedCAS
 * <p/>
 * Simulated CAS operation
 * @author Brian Goetz and Tim Peierls
 *         The approach taken by most processor architectures, including IA32 and Sparc, is to implement a compare-and-swap (CAS) instruction. (Other
 *         processors, such as PowerPC, implement the same functionality with a pair of instructions: loadlinked and store-conditional.) CAS has
 *         three operandsa memory location V on which to operate, the expected old value A, and the newvalue B. CAS atomically updates V to the new value B,
 *         but only if the value in V matches the expected old value A; otherwise it does nothing. In either case, it returns the value currently in
 *         V. (The variant called compare-and-set instead returns whether the operation succeeded.) CAS means "I think V should have the value A; if
 *         it does, put B there, otherwise don't change it but tell me I was wrong." CAS is an optimistic techniqueit proceeds with the update in the
 *         hope of success, and can detect failure if another thread has updated the variable since it was last examined. SimulatedCAS
 *         illustrates the semantics (but not the implementation or performance) of CAS.
 */

@ThreadSafe
public class SimulatedCAS {

    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue)
            value = newValue;
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return (expectedValue == compareAndSwap(expectedValue, newValue));
    }
}
