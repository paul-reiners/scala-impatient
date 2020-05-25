package chapter19.exercise01

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r

  def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
  def term: Parser[Any] = factor ~ rep(("*" | "/" | "%") ~ factor)
  def factor: Parser[Any] = number | "(" ~ expr ~ ")"
}

object ExprParser {
  def main(args: Array[String]): Unit = {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "3-4+5")
    if (result.successful) println(result.get)
    val resultDivision = parser.parseAll(parser.expr, "(3-4+5) / 2 % 3")
    if (resultDivision.successful) println(resultDivision.get)
  }
}
