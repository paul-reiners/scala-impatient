package chapter19.exercise02

class ExprParserTest extends org.scalatest.FunSuite {

  test("exercise02") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "4^2^3")
    if (!result.successful) {
      println(result)
    }
    assert(result.successful)
    assert(result.get == 65536)
  }

  test("exercise02_2") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.pow, "4^2^3")
    if (!result.successful) {
      println(result)
    }
    assert(result.successful)
    assert(result.get == 65536)
  }

  test("exercise02_1") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "2^3")
    if (!result.successful) {
      println(result)
    }
    assert(result.successful)
    assert(result.get == 8)
  }

  test("multiplicationPrecedence") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "2 + 3 * 4")
    assert(result.successful)
    assert(result.get == 14)
  }
}
