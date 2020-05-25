package chapter19.exercise02

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r

  def expr: Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)
  def term: Parser[Any] = pow ~ rep("*" ~ pow | "/" ~ pow)
  def pow: Parser[Any] = rep(factor~"^")~factor
  def factor: Parser[Any] = number | "(" ~ expr ~ ")"
}

object ExprParser {
  def main(args: Array[String]): Unit = {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "3-4+5")
    if (result.successful) println(result.get)
    val resultMultiplication = parser.parseAll(parser.expr, "(3-4+5) * 2")
    if (resultMultiplication.successful) println(resultMultiplication.get)

    val powResult = parser.parseAll(parser.expr, "4^2^3")
    if (powResult.successful) println(powResult.get)
  }
}
