package chapter09

import scala.io.Source

object Exercise06 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("src\\main\\scala\\chapter09\\exercise05.java", "UTF-8")
    val lines = source.getLines().mkString
    val stringPattern = """"[^"]*"""".r
    val matches = stringPattern.findAllIn(lines)
    for (m <- matches) {
      println(m)
    }

    source.close()
  }
}
