package chapter09

import scala.io.Source

object Exercise04 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("src\\main\\scala\\chapter09\\exercise04.txt", "UTF-8")
    val tokens = source.mkString.split("\\s+")
    val numbers = tokens.map(_.toDouble)

    val sum = numbers.sum
    println(s"sum: $sum")
    println(s"average: ${sum / numbers.length}")
    println(s"maximum: ${numbers.max}")
    println(s"minimum: ${numbers.min}")

    source.close()
  }
}
