package chapter19.exercise02

import chapter19.RequestMappingParser.parseAll
import chapter19.exercise01.ExprParser

class ExprParserTest extends org.scalatest.FunSuite {

  test("exercise02") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "4^2^3")
    if (result.successful) println(result.get)
    assert(result.successful)
  }
}
