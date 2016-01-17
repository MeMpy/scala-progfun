//a rational is a number k
//where k = x/y and x,y are Int
class Rational(x:Int, y:Int){
  //All the class body can be considered as
  //the default constructor. Every time a new object
  //is instantiated every evaluation line of the body is executed
  //in out case it will be executed require and val g
  //for example the require function throws an error if the
  //denominator passed in the constructor is zero
  require(y!=0, "denominator must be nonzero")
  private def gcd(a:Int, b:Int):Int = if (b==0) a else gcd(b, a%b)
  private val g = gcd(x,y)

  //The constructors are special method
  //that can handle different number of parameter
  //But they have to call the default one in order to create
  //the instance
  // http://stackoverflow.com/questions/1095329/scala-constructor-overload
  def this(x:Int) = this(x,1)

  def num = x// /g
  def denum = y// /g
  private def simplyfiedNum = num/g
  private def simplyfiedDenum = denum/g
  //We can also wrote
  //val num = x / gcd(x,y)
  //This will be the same of the previous one because
  //with val we evaluate the expression and so the gcd only the first time
  //instead with
  //def num = x/gcd(x,y)
  //this will be different because we evaluate gcd every time we
  //call num. In other word def define a function, val define a field

  def neg = new Rational(-x,y)

  def add(r:Rational) = {
    val newNum = (num*r.denum)+(r.num*denum)
    val newDenum = (denum*r.denum)
    new Rational(newNum,newDenum)
  }

  def sub(r:Rational)= add(r.neg)

  //override def toString = num + "/" + denum
  override def toString = simplyfiedNum + "/" + simplyfiedDenum
}


val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
x.add(y)
x.neg
x.sub(y)
x.sub(y).sub(z)
//Infix notation. Every method that accept one
//argument can be written in infix notation
x sub y sub z


//val k = new Rational(2,0)