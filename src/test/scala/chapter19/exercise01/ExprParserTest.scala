package chapter19.exercise01

import chapter19.RequestMappingParser.parseAll

class ExprParserTest extends org.scalatest.FunSuite {

  test("exercise02") {
    val result = parseAll("""@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)""")
    assert(result.successful)
  }
}
