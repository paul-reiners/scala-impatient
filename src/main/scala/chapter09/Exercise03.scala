package chapter09

import scala.io.Source

object Exercise03 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("src\\main\\scala\\chapter09\\exercise03.txt", "UTF-8")
    for (word <- "[a-zA-Z]+".r.findAllIn(source.getLines().mkString("\n")).filter((word: String) => word.length > 12)) println(word)

    source.close()
  }
}
