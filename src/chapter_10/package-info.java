/**
 * Created by User on 18.11.2016.
 * Avoiding Liveness Hazards chapter.
 *
 * Avoid the temptation to use thread priorities, since they increase platform dependence and can cause liveness problems.
 * Most concurrent applications can use the default priority for all threads.
 *
 * Liveness failures are a serious problem because there is no way to recover from them short of aborting the application.
 * The most common form of liveness failure is lock-ordering deadlock. Avoiding lock ordering deadlock starts at design time:
 * ensure that when threads acquire multiple locks, they do so in a consistent order. The best way to do this is by using open calls throughout
 * your program. This greatly reduces the number of places where multiple locks are held at once, and makes it more obvious where those places are.
 */
package chapter_10;