/**
 * Created by User on 11.11.2016.
 * Cancellation and Shutdown chapter.
 *
 * There is nothing in the API or language specification that ties interruption to any specific cancellation semantics, but in practice, using
 * interruption for anything but cancellation is fragile and difficult to sustain in larger applications.
 * 
 * Interruption is usually the most sensible way to implement cancellation.
 */
package chapter_7;