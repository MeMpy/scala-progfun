/**
  * Implicit is the way scala makes extension
  * methods but is more powerful and ... implicit
  * implicit keyword can declare two types of features
  * 1. Conversion methods
  * 2. Implicit parameters
  */

case class A(x:Int){
  def + (a:A):A = new A(x + a.x)
  def sqrt = x * x
}

val a = new A(10)

/**
  * Conversion methods
  * A conversion method is a method declared implicit
  * that accept one parameter of type X ( in principle can accept also many arguments see here http://stackoverflow.com/questions/10935232/scala-implicit-method-with-multiple-arguments )
  * and returns a value of type Y != X
  * The fancy thing is that you don't need to invoke it
  * it's the compiler that try to apply it as soon as there is
  * a type mismatch. There are some rules to follow to be sure ( http://www.artima.com/pins1ed/implicit-conversions-and-parameters.html#21.2 )
  * that the conversion method will be applied:
  * 1) the method must be in a direct scope ( no dot notation )
  * 2) no conversion method chain
  * 3) if there is ambiguity ( many conversion applicable ) no conversion is applied
  * 4) if no conversion is needed no conversion is applied
  *
  */
implicit def intToA(x:Int):A = new A(x)

a + 8

1 + a

//ambiguity problem
//implicit def intToDouble(x:Int):A = new A(x)
/**
  * Converting the receiver:
  * This is another way to use conversion methods
  * this reminds exactly the extension method of .NET
  * in this scenario we are trying to call the method sqrt
  * on a integer, off course int class doesn't have this method
  * but the compiler try to apply the conversion, and since sqrt is
  * contained in class A it apply successfully the converter and
  * everything works fine.
  * In this example 5 acts like an object of class A
  */
5.sqrt

def sumA(x:A, y:A) = x + y
def sumImplicit(x:Int, y:Int):A = x + y

/**
  * Off course it's possible to use conversion also
  * to invoke method with the correct type.
  */
sumA(5,6)

/**
  * Another useful feature of conversion method is creating
  * new syntax, i.e. extending the operators list.
  * It is already used inside the language itself for exemaple
  * with the -> to create tuple and maps
  * But anybody can create its own operators to construct new
  * data structure on the fly.
  */
/**
  * In this example OperatorsExt defines a new operator
  * :-> that create a list with 2 elements, the first one is
  * an object of type A with parameter x equals to the second
  * argument of the operator and as second element of the list
  * the first argument of the operator
  */
class OperatorsExt[Y](x:Y){
  def :-> (a:Int)= List(new A(a), x)
}

/**
  * The operator is created inside the class OperatorExt
  * but it would be useless without an implicit conversion method
  * because otherwise every time we would use it we should explicitly
  * convert the object into an OperatorExt. So implicit conversion come
  * in handy converting Any type into OperatorsExt in order to apply
  * the operator every where :)
  */
implicit def anyToOperatorExt[Y](x:Y):OperatorsExt[Y] = new OperatorsExt(x)

"string" :-> 1

/**
  * Implicit parameters
  * The second feature provided by implicit are
  * implicit parameters. In this way you can define
  * a function with some implicit parameters through
  * carring.  The parameters list marked as implicit
  * should be replaced by the compiler with arguments
  * marked implicit as well. In this way you can invoke
  * the method with only the explicit parameter but you can
  * use the implicit parameters within the method.
  * Typically the implicit parameter should be used to enrich
  * the explicit parameters, they should provide extra information to
  * them.
  * In that case it seems that the implicit parameter is passed
  * "automatically" to the method. This off course has nothing in common
  * with conversion method.
  */
def prodA(x:Int)(implicit y:A): A = x.x * y.x

implicit val implA = new A(4)
prodA(6)

/**
  * A very interesting example show how implicit
  * expression block scope works.
  * In an expression block compiler can only access
  * to the implicit declared or imported inside the block
  */

{
  implicit val implA = new A(6)
  prodA(6)
}

