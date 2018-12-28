lazy val cassandraSetup = taskKey[Unit]("Setup Cassandra keyspace")
lazy val cassandraDrop = taskKey[Unit]("Drop Cassandra keyspace")
lazy val cassandraReset =
  taskKey[Unit]("Drop Cassandra keyspace and setup it again")
lazy val cassandraKeyspace =
  settingKey[String]("Cassandra keyspace to work with")

cassandraKeyspace := "observatory"

cassandraSetup := {
  val schemaFile = (Compile / resourceDirectory).value / "cassandra" / "schema.cql"

  import scala.sys.process._
  Seq("cqlsh", "-f", schemaFile.absolutePath).!
}

cassandraDrop := {
  import scala.sys.process._
  Seq("cqlsh", "-e", s"drop keyspace if exists ${cassandraKeyspace.value}").!
}

cassandraReset := Def.sequential(cassandraDrop, cassandraSetup).value
