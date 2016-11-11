/**
 * Created by User on 11.11.2016.
 * Finding Exploitable Parallelism section.
 *
 * The Executor framework makes it easy to specify an execution policy, but in order to use an Executor, you have to be able to describe your task as
 * a Runnable. In most server applications, there is an obvious task boundary: a single client request. But sometimes good task boundaries are not
 * quite so obvious, as in many desktop applications. There may also be exploitable parallelism within a single client request in server applications,
 * as is sometimes the case in database servers.
 *
 * The real performance payoff of dividing a program's workload into tasks comes when there are a large number of independent,
 * homogeneous tasks that can be processed concurrently.
 */
package chapter_6.section_3;