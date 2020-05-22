package chapter19

import scala.util.parsing.combinator.RegexParsers

class RequestMappingParser extends RegexParsers {
  def requestMapping: Parser[Any] = "^@RequestMapping\\(".r ~ commaDelimitedSeq ~ "\\)$".r
  def commaDelimitedSeq: Parser[Any] = keyValue ~ rep("," ~ keyValue)
  def keyValue: Parser[Any] = key ~ "=" ~ value
  def key: Parser[Any] = "value" | "method"
  def value: Parser[Any] = """[^)]*""".r
}

object RequestMappingParser {
  def main(args: Array[String]): Unit = {
    val result = parseAll
    if (result.successful) println(result.get)
  }

  private def parseAll = {
    val parser = new RequestMappingParser
    val result =
      parser.parseAll(parser.requestMapping, """@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)""")
    result
  }
}
