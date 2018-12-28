package one.observatory.cassandra.tables

import com.outworkers.phantom.NamingStrategy.SnakeCase.caseInsensitive
import com.outworkers.phantom.dsl._
import one.observatory.cassandra.Primitives._
import one.observatory.cassandra.data.{Location, StackFrame}
import one.observatory.cassandra.records.ExceptionOccurrencesRecord

abstract class ExceptionOccurrences
    extends Table[ExceptionOccurrences, ExceptionOccurrencesRecord] {

  object exceptionId extends UUIDColumn with PartitionKey

  object occurredAt extends DateTimeColumn with ClusteringOrder with Ascending

  object occurrenceId extends UUIDColumn with ClusteringOrder with Ascending

  object simpleClassName extends StringColumn

  object canonicalClassName extends StringColumn

  object throwLocation extends JsonColumn[Location]

  object catchLocation extends OptionalJsonColumn[Location]

  object host extends StringColumn

  object processPid extends IntColumn

  object threadName extends StringColumn

  object message extends OptionalStringColumn

  object frames extends JsonColumn[Seq[StackFrame]]
}
