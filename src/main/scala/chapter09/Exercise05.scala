package chapter09

import java.io.PrintWriter

object Exercise05 {
  def main(args: Array[String]): Unit = {
    val out = new PrintWriter("exercise05.txt")
    for (i <- 0 to 20) {
      val power = math.pow(2, i).toInt
      out.println(f"$power%7d ${1.0 / power}")
    }
    out.close()
  }
}
