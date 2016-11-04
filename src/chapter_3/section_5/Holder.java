package chapter_3.section_5;

/**
 * Holder
 * <p/>
 * Class at risk of failure if not properly published
 * @author Brian Goetz and Tim Peierls
 *         However, Holder can be made immune to improper publication by declaring the n field to be final, which would make Holder immutable
 */
public class Holder {

    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}
