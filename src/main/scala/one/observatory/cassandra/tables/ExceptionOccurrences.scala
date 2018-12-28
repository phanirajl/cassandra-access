package one.observatory.cassandra.cassandra.tables

import com.outworkers.phantom.dsl._
import one.observatory.webapp.cassandra.records.ExceptionOccurrence
import com.outworkers.phantom.NamingStrategy.SnakeCase.caseInsensitive

abstract class ExceptionOccurrences
    extends Table[ExceptionOccurrences, ExceptionOccurrence] {

  object url extends StringColumn with PartitionKey

  object description extends OptionalStringColumn

  object ingredients extends ListColumn[String]

  object servings extends OptionalIntColumn

  object lastcheckedat extends DateTimeColumn

  object props extends MapColumn[String, String]

  object uid extends UUIDColumn
}
