package one.observatory.cassandra.data

case class Location(className: String,
                    memberName: String,
                    lineNumber: Option[Int])
