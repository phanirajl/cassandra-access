package one.observatory.cassandra

import com.outworkers.phantom.dsl.{Database => PhantomDatabase}
import one.observatory.cassandra.tables.ExceptionOccurrences

class CassandraDatabase(connection: CassandraConnection)
    extends PhantomDatabase[CassandraDatabase](connection.default) {

  object exceptionOccurrences extends ExceptionOccurrences with Connector {}
}
