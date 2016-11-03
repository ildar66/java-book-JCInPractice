/**
 * Created by User on 03.11.2016.
 * Publication and Escape
 *
 * Publishing an object means making it available to code outside of its current scope, such as by storing a reference to it where other code can find
 * it, returning it from a nonprivate method, or passing it to a method in another class. In many situations, we want to ensure that objects and their
 * internals are not published. In other situations, we do want to publish an object for general use, but doing so in a thread-safe manner may require
 * synchronization. Publishing internal state variables can compromise encapsulation and make it more difficult to preserve invariants; publishing
 * objects before they are fully constructed can compromise thread safety. An object that is published when it should not have been is said to have
 * escaped.
 */
package chapter_3.section_2;