/**
 * Created by User on 04.11.2016.
 * Safe Publication
 *
 * Immutable objects can be used safely by any thread without additional synchronization, even when synchronization is not used to publish them.
 *
 * This guarantee extends to the values of all final fields of properly constructed objects; final fields can be safely accessed without additional
 * synchronization. However, if final fields refer to mutable objects, synchronization is still required to access the state of the objects they refer
 * to.
 *
 * Objects that are not immutable must be safely published.
 * Safe Publication Idioms:

    To publish an object safely, both the reference to the object and the object's state must be made visible to other threads at the same time.
    A properly constructed object can be safely published by:

         Initializing an object reference from a static initializer;

         Storing a reference to it into a volatile field or AtomicReference;

         Storing a reference to it into a final field of a properly constructed object; or

         Storing a reference to it into a field that is properly guarded by a lock.
 *
 *
 * Objects that are not technically immutable, but whose state will not be modified after publication, are called effectively immutable.
 * Safely published effectively immutable objects can be used safely by any thread without additional synchronization.
 *
    * For example, Date is mutable, but if you use it as if it were immutable, you may be able to eliminate the locking that would otherwise
    * be required when shared a Date across threads. Suppose you want to maintain a Map storing the last login time of each user:
        public Map<String, Date> lastLogin = Collections.synchronizedMap(new HashMap<String, Date>());
 */
package chapter_3.section_5;

