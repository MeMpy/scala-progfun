abstract class IntSet{
  def incl(x:Int):IntSet
  def contains(x:Int): Boolean
  def union(other: IntSet):IntSet
}

class NonEmptySet(left:IntSet, elem:Int, right:IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if(x<elem) new NonEmptySet(left.incl(x), elem, right)
    else if(x>elem) new NonEmptySet(left, elem, right.incl(x))
    else this
  }

  //override is mandatory when we override a real class method, for abstract method
  //override is optional
  override def contains(x: Int): Boolean =
    if(x==elem) true else if(x<elem) left.contains(x) else right.contains(x)

  override def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem //BHO
}

//object is like a singleton, you cannot instantiate this class but you always
//have to refer to it using its name (see incl)
object EmptySet extends IntSet{
  def incl(x:Int):IntSet = {
    new NonEmptySet(EmptySet, x, EmptySet)
  }

  def contains(x:Int) = {
    false
  }

  def union(other: IntSet): IntSet = other
}