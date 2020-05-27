package chapter09

import java.io.PrintWriter

import scala.io.Source

object Exercise02 {
  def main(args: Array[String]): Unit = {
    val n = 5
    val fileName = "myfile.txt"
    val source = Source.fromFile(fileName, "UTF-8")
    val lines = source.getLines.toArray
    val len = lines.length
    val newLines = new Array[String](len)
    for (i <- 0 until len) {
      val line = lines(i)
      val buf: StringBuilder = new StringBuilder()
      for (c <- line.toCharArray) {
        if (c.equals('\t')) {
          val rem = buf.length() % n
          val numBlanks = if (rem == 0) n else rem
          for (j <- 0 until numBlanks) {
            buf.append(' ')
          }
        } else {
          buf.append(c)
        }
      }
      newLines(i) = buf.toString()
    }
    val out = new PrintWriter(fileName)
    for (line <- newLines) {
      out.println(line)
    }
    out.close()
  }
}
