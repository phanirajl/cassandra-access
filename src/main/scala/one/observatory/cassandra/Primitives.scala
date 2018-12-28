package one.observatory.cassandra

import com.outworkers.phantom.builder.primitives.Primitive
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import one.observatory.cassandra.data.{Location, StackFrame}

object Primitives {
  implicit val locationPrimitive: Primitive[Location] = {
    Primitive.json[Location](js => js.asJson.noSpaces)(jsonString =>
      decode[Location](jsonString).right.get)
  }

  implicit val stackFramesSeqPrimitive: Primitive[Seq[StackFrame]] = {
    Primitive.json[Seq[StackFrame]](js => js.asJson.noSpaces)(jsonString =>
      decode[Seq[StackFrame]](jsonString).right.get)
  }
}
