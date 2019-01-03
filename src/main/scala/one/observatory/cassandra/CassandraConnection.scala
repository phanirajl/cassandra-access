package one.observatory.cassandra

import com.datastax.driver.core.{PlainTextAuthProvider, SocketOptions}
import com.outworkers.phantom.connectors.{
  ContactPoint,
  CassandraConnection => PhantomCassandraConnection
}

class CassandraConnection(config: CassandraConfig) {

  val default: PhantomCassandraConnection =
    ContactPoint(config.host, config.port)
      .withClusterBuilder(
        _.withSocketOptions(
          new SocketOptions()
            .setConnectTimeoutMillis(config.connectTimeout.toMillis.toInt)
            .setReadTimeoutMillis(config.readTimeout.toMillis.toInt)
        ).withAuthProvider(
          new PlainTextAuthProvider(config.username, config.password)))
      .keySpace(config.keyspace, autoinit = false)
}
