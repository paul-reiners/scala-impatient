package chapter20.exercise02

class ExprParserTest extends org.scalatest.FunSuite {
  test("expr") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "3-4*5")
    assert(result.successful)
    assert(result.get == -17)
  }

  test("left-associativity of subtraction") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "3-4-5")
    assert(result.successful)
    assert(result.get == -6)
  }

  test("pow") {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "4^2^3")
    assert(result.successful)
    assert(result.get == 65536)
  }
}
