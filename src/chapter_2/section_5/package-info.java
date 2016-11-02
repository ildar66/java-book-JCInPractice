/**
 * Created by User on 02.11.2016.
 * Liveness and Performance
 *
 * There is frequently a tension between simplicity and performance. When implementing a synchronization policy, resist the temptation to prematurely
 * sacriflce simplicity (potentially compromising safety) for the sake of performance.
 *
 * Avoid holding locks during lengthy computations or operations at risk of not completing quickly such as network or console I/O.
 */
package chapter_2.section_5;