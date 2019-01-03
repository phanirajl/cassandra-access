package one.observatory.cassandra.tables

import com.outworkers.phantom.NamingStrategy.SnakeCase.caseInsensitive
import com.outworkers.phantom.dsl._
import one.observatory.cassandra.Primitives._
import one.observatory.cassandra.data.{Location, StackFrame}
import one.observatory.cassandra.records.ExceptionOccurrencesRecord

import scala.concurrent.Future

abstract class ExceptionOccurrences
    extends Table[ExceptionOccurrences, ExceptionOccurrencesRecord] {

  object exceptionId extends UUIDColumn with PartitionKey

  object occurredAt extends DateTimeColumn with ClusteringOrder with Ascending

  object occurrenceId extends UUIDColumn with ClusteringOrder with Ascending

  object className extends StringColumn

  object throwLocation extends JsonColumn[Location]

  object catchLocation extends OptionalJsonColumn[Location]

  object host extends StringColumn

  object processPid extends IntColumn

  object threadName extends StringColumn

  object message extends OptionalStringColumn

  object frames extends JsonColumn[Seq[StackFrame]]

  private lazy val insertQuery =
    insert()
      .p_value(_.exceptionId, ?)
      .p_value(_.occurredAt, ?)
      .p_value(_.occurrenceId, ?)
      .p_value(_.className, ?)
      .p_value(_.throwLocation, ?)
      .p_value(_.catchLocation, ?)
      .p_value(_.host, ?)
      .p_value(_.processPid, ?)
      .p_value(_.threadName, ?)
      .p_value(_.message, ?)
      .p_value(_.frames, ?)
      .prepareAsync()

  def insert(record: ExceptionOccurrencesRecord): Future[ResultSet] =
    insertQuery.flatMap(_.bind(record).future())
}
