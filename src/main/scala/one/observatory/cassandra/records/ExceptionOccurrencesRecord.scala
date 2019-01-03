package one.observatory.cassandra.records

import java.util.UUID

import one.observatory.cassandra.data.{Location, StackFrame}
import org.joda.time.DateTime

case class ExceptionOccurrencesRecord(
    exceptionId: UUID,
    occurredAt: DateTime,
    occurrenceId: UUID,
    className: String,
    throwLocation: Location,
    catchLocation: Option[Location],
    host: String,
    processPid: Int,
    threadName: String,
    message: Option[String],
    frames: Seq[StackFrame]
)
