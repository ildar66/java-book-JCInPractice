/**
 * Created by User on 04.11.2016.
 * Immutability
 *
 * Immutable objects are always thread-safe.
 *
 * An object is immutable if:
 *      Its state cannot be modifled after construction;
 *      All its flelds are final; and
 *      It is properly constructed (the this reference does not escape during construction).
 *
 *      Just as it is a good practice to make all fields private unless they need greater visibility [EJ Item 12],
 *      it is a good practice to make all fields final unless they need to be mutable.
 */
package chapter_3.section_4;