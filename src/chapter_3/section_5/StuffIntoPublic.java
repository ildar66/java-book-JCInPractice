package chapter_3.section_5;

/**
 * StuffIntoPublic
 * <p/>
 * Unsafe publication
 * @author Brian Goetz and Tim Peierls
 *         Because of visibility problems, the Holder could appear to another thread to be in an inconsistent state, even though its invariants were
 *         properly established by its constructor! This improper publication could allow another thread to observe a partially constructed object.
 */
public class StuffIntoPublic {

    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
