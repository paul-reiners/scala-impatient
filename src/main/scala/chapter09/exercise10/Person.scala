package chapter09.exercise10

import java.io._

import scala.collection.mutable.ArrayBuffer

class Person(val name: String) extends Serializable {
  val friends = new ArrayBuffer[Person]

  // OK—ArrayBuffer is serializable
  def description: String = name + " with friends " +
    friends.map(_.name).mkString(", ")
}

object Person {
  def main(args: Array[String]): Unit = {
    val fred = new Person("Fred")
    val wilma = new Person("Wilma")
    val barney = new Person("Barney")
    fred.friends += wilma
    fred.friends += barney
    wilma.friends += barney
    barney.friends += fred

    val out = new ObjectOutputStream(new FileOutputStream("test.obj"))
    out.writeObject(fred)
    out.close()
    val in = new ObjectInputStream(new FileInputStream("test.obj"))
    val savedFred = in.readObject().asInstanceOf[Person]
    in.close()

    println(savedFred.description)
    println(savedFred.friends.map(_.description))

    val people = Array(fred, wilma, barney)

    val peopleOut = new ObjectOutputStream(new FileOutputStream("people.obj"))
    peopleOut.writeObject(people)
    peopleOut.close()
    val peopleIn = new ObjectInputStream(new FileInputStream("people.obj"))
    val savedPeople = peopleIn.readObject().asInstanceOf[Array[Person]]
    peopleIn.close()

    println(savedPeople(0).description)
    println(savedPeople(0).friends.map(_.description))
  }
}
