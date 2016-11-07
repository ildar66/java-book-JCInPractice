/**
 * Created by User on 07.11.2016.
 * Delegating Thread Safety section.
 *
 * If a class is composed of multiple independent thread-safe state variables and has no operations that have any invalid state transitions,
 * then it can delegate thread safety to the underlying state variables.
 *
 * If a state variable is thread-safe, does not participate in any invariants that constrain its value, and has no prohibited state transitions
 * for any of its operations, then it can safely be published.
 */
package chapter_4.section_3;