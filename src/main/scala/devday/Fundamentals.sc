val string1: String = "Rosario"

val string2 = "Davide"

//string2 = "pip"

var string3 = "Marco"

string3 = "Giuseppe"


def sayHello(arg: String): String = {
  s"hello to $arg" //inline string interpolation
}

//def sayHello(arg:String) = s"hello to $arg"

sayHello(string1)

//class Person(val name: String)

val p = new Person(string1)


object MySelf extends Person(string1)

//val p1 = new MySelf
MySelf.name

trait LivingEntity {
  def breath(): String
}

abstract class WalkingEntity {
  def walk() = "walking..."
}

class Person(val name: String) extends WalkingEntity with LivingEntity {
  override def breath(): String = "breathing..."
}

case class BetterPerson(name: String) extends WalkingEntity

val bp = BetterPerson(string1)

bp.copy(name = string2)


def distanceSoFar(entity: WalkingEntity): Int = {
  entity match {
    case x: Person =>
      println(s"${x.name} is ${x.walk()}")
      1
    case MySelf =>
      println(s"${MySelf.name} is ${MySelf.walk()}")
      2
    case x: BetterPerson =>
      println(s"${x.name} is ${x.walk()}")
      3
    case _ => 0
  }

}

distanceSoFar(MySelf)
distanceSoFar(bp)









