package one.observatory.cassandra.records

case class ExceptionOccurrence(
    url: String,
    description: Option[String],
    ingredients: List[String],
    servings: Option[Int],
    props: Map[String, String],
)
