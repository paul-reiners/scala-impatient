package chapter09

import scala.io.Source

object Exercise08 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromURL("https://horstmann.com/", "UTF-8")
    // <img alt='' src='images/violet.jpg' style='border: 0px solid ; width: 73px; height: 76px;' title=''/>
    val imgPattern = "<img.*src=('[^\\s]*').*/>".r
    val str = source.mkString
    for (m <- imgPattern.findAllMatchIn(str)) {
      println(m.group(1))
    }

    source.close()
  }
}
