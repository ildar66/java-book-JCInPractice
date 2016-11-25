/**
 * Created by User on 25.11.2016.
 * Read-write Locks section.
 * 
 * The interaction between the read and write locks allows for a number of possible implementations. Some of the implementation options for a
 * ReadWriteLock are:
 * Release preference. When a writer releases the write lock and both readers and writers are queued up, who should be given preferencereaders,
 * writers, or whoever asked first?
 * Reader barging. If the lock is held by readers but there are waiting writers, should newly arriving readers be granted immediate access, or should
 * they wait behind the writers? Allowing readers to barge ahead of writers enhances concurrency but runs the risk of starving writers.
 * Reentrancy. Are the read and write locks reentrant?
 * Downgrading. If a thread holds the write lock, can it acquire the read lock without releasing the write lock? This would let a writer "downgrade"
 * to a read lock without letting other writers modify the guarded resource in the meantime.
 * Upgrading. Can a read lock be upgraded to a write lock in preference to other waiting readers or writers? Most read-write lock implementations do
 * not support upgrading, because without an explicit upgrade operation it is deadlock-prone. (If two readers simultaneously attempt to upgrade to a
 * write lock, neither will release the read lock.)
 */
package chapter_13.section_5;