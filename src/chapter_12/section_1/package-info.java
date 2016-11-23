/**
 * Created by User on 23.11.2016.
 * Testing for Correctness section.
 *
 * The challenge to constructing effective safety tests for concurrent classes is identifying easily checked properties that will, with high
 * probability, fail if something goes wrong, while at the same time not letting the failureauditing code limit concurrency artificially. It is best
 * if checking the test property does not require any synchronization.
 * 
 * Tests should be run on multiprocessor systems to increase the diversity of potential interleavings. However, having more than a few CPUs does not
 * necessarily make tests more effective. To maximize the chance of detecting timing-sensitive data races, there should be more active threads than
 * CPUs, so that at any given time some threads are running and some are switched out, thus reducing the predicatability of interactions between
 * threads.
 */
package chapter_12.section_1;