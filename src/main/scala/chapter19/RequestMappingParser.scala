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
    val result = parseAll("""@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)""")
    if (result.successful) println(result.get)
  }

  def parseAll(requestMappingStr: String) = {
    val parser = new RequestMappingParser
    val result =
      parser.parseAll(parser.requestMapping, requestMappingStr)
    result
  }
}
