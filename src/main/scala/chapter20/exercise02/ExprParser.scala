package chapter20.exercise02

import scala.util.matching.Regex
import scala.util.parsing.combinator._

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r
  def expr: Parser[Int] = term ~ rep(
    ("+" | "-") ~ term ^^ {
      case "+" ~ t => t
      case "-" ~ t => -t
    }) ^^ { case t ~ r => t + r.sum }

  def term: Parser[Int] = factor ~ rep("*" ~ factor) ^^ {
    case f ~ r => f * r.map(_._2).product
  }

  def powRec(ints: List[Int]): Int = {
    if (ints.length == 1) {
      ints.head
    } else {
      math.pow(ints.head, powRec(ints.tail)).toInt
    }
  }

  def factor: Parser[Int] = exponentOrBase ~ rep("^" ~ exponentOrBase) ^^ {
    case b ~ Nil => b
    case b ~ r => math.pow(b, powRec(r.map(_._2))).toInt
  }

  def exponentOrBase: Parser[Int] = number ^^ { _.toInt } | "(" ~ expr ~ ")" ^^ {
    case _ ~ e ~ _ => e
  }
}

object Main extends App {
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5")
  if (result.successful) println(result.get)
}
