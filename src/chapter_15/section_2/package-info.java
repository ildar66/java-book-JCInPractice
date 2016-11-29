/**
 * Created by User on 29.11.2016.
 * Hardware Support for Concurrency chapter.
 * 
 * Processors designed for multiprocessor operation provide special instructions for managing concurrent access to shared variables. Early processors
 * had atomic test-and-set, fetch-and-increment, or swap instructions sufficient for implementing mutexes that could in turn be used to implement more
 * sophisticated concurrent objects. Today, nearly every modern processor has some form of atomic read-modify-write instruction, such as
 * compare-and-swap or load-linked/store-conditional. Operating systems and JVMs use these instructions to implement locks and concurrent data
 * structures, but until Java 5.0 they had not been available directly to Java classes.
 */
package chapter_15.section_2;