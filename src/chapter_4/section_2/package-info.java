/**
 * Created by User on 07.11.2016.
 * Instance Confinement section.
 *
 * Encapsulating data within an object confines access to the data to the object's methods, making it easier to ensure that the data is always
 * accessed with the appropriate lock held.
 *
 * Confinement makes it easier to build thread-safe classes because a class that confines its state can be analyzed for thread safety
 * without having to examine the whole program.
 */
package chapter_4.section_2;