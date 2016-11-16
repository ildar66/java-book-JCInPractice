/**
 * Created by User on 15.11.2016.
 * Implicit Couplings Between Tasks and Execution Policies section.
 *
 * Some tasks have characteristics that require or preclude a specific execution policy. Tasks that depend on other tasks require that the thread
 * pool be large enough that tasks are never queued or rejected; tasks that exploit thread confinement require sequential execution. Document these
 * requirements so that future maintainers do not undermine safety or liveness by substituting an incompatible execution policy.
 * 
 * Whenever you submit to an Executor tasks that are not independent, be aware of the possibility of thread starvation deadlock, and document any pool
 * sizing or configuration constraints in the code or configuration file where the Executor is configured.
 */
package chapter_8.section_1;