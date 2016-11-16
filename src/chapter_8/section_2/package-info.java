/**
 * Created by User on 16.11.2016.
 * Sizing Thread Pools section.
 * The ideal size for a thread pool depends on the types of tasks that will be submitted and the characteristics of the deployment system. Thread
 * pool
 * sizes should rarely be hard-coded; instead pool sizes should be provided by a configuration mechanism or computed dynamically by consulting
 * Runtime.availableProcessors.
 * Sizing thread pools is not an exact science, but fortunately you need only avoid the extremes of "too big" and "too small". If a thread pool is
 * too
 * big, then threads compete for scarce CPU and memory resources, resulting in higher memory usage and possible resource exhaustion. If it is too
 * small, throughput suffers as processors go unused despite available work.
 * To size a thread pool properly, you need to understand your computing environment, your resource budget, and the nature of your tasks. How many
 * processors does the deployment system have? How much memory? Do tasks perform mostly computation, I/O, or some combination? Do they require a
 * scarce resource, such as a JDBC connection? If you have different categories of tasks with very different behaviors, consider using multiple
 * thread
 * pools so each can be tuned according to its workload.
 * For compute-intensive tasks, an Ncpu-processor system usually achieves optimum utilization with a thread pool of Ncpu +1 threads. (Even
 * compute-intensive threads occasionally take a page fault or pause for some other reason, so an "extra" runnable thread prevents CPU cycles from
 * going unused when this happens.) For tasks that also include I/O or other blocking operations, you want a larger pool, since not all of the
 * threads
 * will be schedulable at all times. In order to size the pool properly, you must estimate the ratio of waiting time to compute time for your tasks;
 * this estimate need not be precise and can be obtained through pro-filing or instrumentation. Alternatively, the size of the thread pool can be
 * tuned by running the application using several different pool sizes under a benchmark load and observing the level of CPU utilization.
 * Given these definitions:
 * The optimal pool size for keeping the processors at the desired utilization is:
 * Nthreads = Ncpu * Ucpu * (1 + W/C);
 * W/C - ratio of wait time to compute time; Ucpu = from 0 to 1(targer SPU utilization); Ncpu - number of CPUs
 * You can determine the number of CPUs using Runtime:
 * int N_CPUS = Runtime.getRuntime().availableProcessors();
 */
package chapter_8.section_2;