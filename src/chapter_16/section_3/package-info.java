/**
 * Created by User on 02.12.2016.
 * Initialization Safety
 *
 * Initialization safety guarantees that for properly constructed objects, all threads will see the correct values of final fields that were set by
 * the constructor, regardless of how the object is published. Further, any variables that can be reached through a final field of a properly
 * constructed object (such as the elements of a final array or the contents of a HashMap referenced by a final field) are also guaranteed to be
 * visible to other threads. [6]
 *
 * [6] This applies only to objects that are reachable only through final fields of the object under construction.
 *
 * Initialization safety makes visibility guarantees only for the values that are reachable through final fields as of the time
 * the constructor finishes. For values reachable through non-final fields, or values that may change after construction,
 * you must use synchronization to ensure visibility.
 */
package chapter_16.section_3;