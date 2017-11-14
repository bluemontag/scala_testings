package parsers

import java.io.FileReader
import scala.util.parsing.combinator._

class JSON extends JavaTokenParsers {
  def value: Parser[Any] = obj | arr |
    stringLiteral |
    floatingPointNumber |
    "null" | "true" | "false"
  def obj: Parser[Any] = "{" ~ repsep(member, ",") ~ "}"
  def arr: Parser[Any] = "[" ~ repsep(value, ",") ~ "]"
  def member: Parser[Any] = stringLiteral ~ ":" ~ value
}

/**
 * This is the same parser, but which returns more meaningful results
 */
class JSON1 extends JavaTokenParsers {
  def obj: Parser[Map[String, Any]]   = "{" ~> repsep(member, ",") <~ "}" ^^ (Map() ++ _)
  def arr: Parser[List[Any]]          = "[" ~> repsep(value, ",") <~ "]"
  def member: Parser[(String, Any)] =  stringLiteral ~ ":" ~ value ^^ { case name ~ ":" ~ value => (name, value) }
  def value: Parser[Any] = ( obj |
                             arr | 
                             stringLiteral |
                             floatingPointNumber ^^ (_.toDouble) |
                             "null" ^^ (x => null) |
                             "true" ^^ (x => true) | "false" ^^ (x => false)
                             )
}

object JSONParser extends JSON1 {
  def main(args: Array[String]) = {
    val reader = new FileReader(args(0))
    println(parseAll(value, reader))
  }
}