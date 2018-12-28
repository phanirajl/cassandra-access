package one.observatory.cassandra
import scala.concurrent.duration.FiniteDuration

case class CassandraConfig(host: String,
                           port: Int,
                           keyspace: String,
                           username: String,
                           password: String,
                           connectTimeout: FiniteDuration,
                           readTimeout: FiniteDuration)
