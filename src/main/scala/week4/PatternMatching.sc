/**
  * The pattern matching is a generalization
  * of the switch case operator.
  * The motivation of this pattern comes from
  * the decomposition system in the OOP.
  * In the follow hierarchy we use the decomposition
  * to understand the type of each instance in order to
  * call the specific method. Of course we could put all the
  * method inside trait but we would have strange behaviors
  * for the methods that don't belong to that class.
  * With this solution we do not have to add lots of method but
  * we use unsefe code because we try everytime to cast
  * the instances to the real class.
 */
trait Expr {

}
class Number(n:Int) extends Expr{
  def getNum = n
}
class Sum(left:Expr,right:Expr) extends Expr{
  def getLeft = left
  def getRight = right
}
def eval(e:Expr):Int={
  if (e.isInstanceOf[Number])
    e.asInstanceOf[Number].getNum
  else
    if (e.isInstanceOf[Sum])
      eval(e.asInstanceOf[Sum].getLeft) + eval(e.asInstanceOf[Sum].getRight)
    else
      throw new Error(e.toString())

}
eval(new Sum(new Number(2), new Number(3)))


/**
  The pattern matching come in help to this situation
  creating a new and safe way to decompose objects
*/
case class NumberC(n:Int) extends Expr
case class Zero(x:Int) extends Expr
case class SumC(left:Expr,right:Expr) extends Expr
case class ProductC(left:Expr,right:Expr) extends Expr
case class Var(x:String) extends Expr

/**
  * a case class is a special class that automatically
  * - add the accessor method
  * - a functional constructor (see NumberCompanion)
  * - the capability to participate to the pattern matching
  */
object NumberCompanion{
  def apply(n:Int) = new NumberC(n)
}

/**
  * As in the switch case operator the pattern
  * matching check if the expression e matches one
  * of the pattern provided in the left side of the
  * case keyword, is yes evaluates the right expression
  * passing to that expression bounded variable
  * from the left side
  *
  * In case of no match an exception is thrown
  *
  */

/**
  * A pattern can be one of the follows:
  * - a constructor Number(p)
  * - a wildcard _ that means everything
  * - a variable e
  * - a constant "1", NumberC(1)
  * -a mix of the previous
  */

def evalC(e:Expr):Int = e match {
    // the constructor pattern allows us to
    // specify a constructor that can take as
    // argument another pattern C(p1,...,pn)
    // in this case the constructor Number takes
    // as parameter the variable pattern n
    case NumberC(n) => n
    // In this case Zero takes as parameter the
    //wildcard pattern.

    //The only difference between the wildcard and
    //the variable pattern is that with the variable
    //pattern we can bind the variable with the expression
    //and we can reuse it in the right side of the case
    case Zero(_) => 0
    //Each constructor pattern continues to be
    //type safe so it accepts as arguments only patterns
    //that match the type of its parameters
    //The constant pattern are compared using ==
    case SumC(NumberC(-1),NumberC(-1)) => 0
    case SumC(e1,e2) => evalC(e1) + evalC(e2)
}

def show(e:Expr):String = e match {
  case ProductC(SumC(e1,e2),e) => "( " + show(SumC(e1,e2)) +" )" + " * " + show(e)
  case NumberC(n) => n.toString
  case SumC(e1,e2) => show(e1) + " + " + show(e2)
  case ProductC(e1,e2) => show(e1) + " * " + show(e2)
  case Var(x) => x
}

evalC(new SumC(new NumberC(2), new NumberC(3)))
evalC(SumC(NumberC(2), NumberC(3)))
evalC(SumC(NumberC(-1), NumberC(-1)))
show(new SumC(new NumberC(2), new NumberC(3)))
show(ProductC(SumC(NumberC(2), Var("x")),Var("y")))
show(SumC(ProductC(NumberC(2), Var("x")),Var("y")))

