/**
  * Traits are the way scala implements multiple inheritance
  * a trait can have abstract methods AND concrete methods
  * you can think of a trait like an interface with also
  * implemented method.
  * In a trait you CANNOT pass parameters and
  * use val initialization.
  */
trait ClassA{

  def anAbstractMethodInA():String

  def aRealMethodInA():String ={
    "aRealMethodInA"
  }

}

trait ClassB{

  def anAbstractMethodInB():String

  def aRealMethodInB(): String ={
    "aRealMethodInB"
  }

}

abstract class ClassC(name:String){

  def anAbstractMethodInC():String

}

//To use the multiple inheritance in scala you have to
//use the with keyword. The with keyword can be used only after
//the extends keyword
class ClassD(name:String) extends ClassC(name) with ClassA with ClassB {
  override def anAbstractMethodInC(): String =
  {
    "D: " + "anAbstractMethodInC"
  }

  override def anAbstractMethodInA(): String = {
    "D: " + "anAbstractMethodInA"
  }

  override def anAbstractMethodInB(): String = {
    "D: " + "anAbstractMethodInB"
  }
  override def aRealMethodInA(): String = {
    "aRealMethodInD"
  }
}
val a = new ClassD("Ross")
a.aRealMethodInA()
a.aRealMethodInB()
a.anAbstractMethodInC()

//we can also use trait in the extends statement
//but we cannot use classes inside the with statement
class ClassE extends ClassA with ClassB{
  override def anAbstractMethodInA(): String = ???

  override def anAbstractMethodInB(): String = ???
}