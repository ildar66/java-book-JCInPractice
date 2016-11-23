/**
 * Created by User on 23.11.2016.
 * Testing for Correctness section.
 * 
 * The challenge to constructing effective safety tests for concurrent classes is identifying easily checked properties that will, with high
 * probability, fail if something goes wrong, while at the same time not letting the failureauditing code limit concurrency artificially. It is best
 * if checking the test property does not require any synchronization.
 */
package chapter_12.section_1;