package parsers
import scala.util.parsing.combinator._
class Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)
  def term: Parser[Any] = factor ~ rep("*" ~ factor | "/" ~ factor)
  def factor: Parser[Any] = floatingPointNumber | "(" ~ expr ~ ")"
}

object ParseExpr extends Arith {
  def main(args: Array[String]) = {
    val sumProd:String  = "3 + (2 * 3)"
    println("input : " + sumProd)
    println(parseAll(expr, sumProd))
  }
}