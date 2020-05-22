package chapter19

import chapter19.RequestMappingParser.parseAll

class RequestMappingParserTest extends org.scalatest.FunSuite {

  test("parseAll") {
    val result = parseAll("""@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)""")
    assert(result.successful)
  }
}
