package chapter09

import java.nio.file._

object Exercise09 {
  def main(args: Array[String]): Unit = {
    val dirname: String = "C:\\Users\\paul.reiners\\IdeaProjects"
    val entries = Files.walk(Paths.get(dirname))
    try {
      entries.forEach(p =>
        if (p.toString.endsWith(".class"))
          println(p))
    } finally {
      entries.close()
    }
  }
}
