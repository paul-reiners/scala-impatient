package chapter09

import scala.io.Source

object Exercise07 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("src\\main\\scala\\chapter09\\exercise07.txt", "UTF-8")
    val tokens = source.mkString.split("\\s+")
    val numPattern = "-?[0-9]+\\.[0-9]+(E-?[0-9]+)?".r
    for (t <- tokens) {
      if (!numPattern.matches(t)) {
        println(t)
      }
    }

    source.close()
  }
}
