//Peano numbers
abstract class Nat{
  def isZero:Boolean

  def successor:Nat

  def predecessor:Nat

  def +(that : Nat): Nat

  def -(that:Nat):Nat
}

object Zero extends Nat{
  override def isZero: Boolean = true

  override def successor: Nat = new Unit(this)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = that

  override def predecessor: Nat = this

  override def toString = "0"
}

class Unit(pred:Nat) extends Nat{
  override def isZero: Boolean = false

  override def successor: Nat = new Unit(this)

  override def +(that: Nat): Nat =
    if(that.isZero) this
    else
      this.successor + that.predecessor

  override def -(that: Nat): Nat =
    if (that.isZero) this
    else
      this.predecessor - that.predecessor

  override def predecessor: Nat = pred

  override def toString =
    "1 + "+predecessor.toString()
}

Zero
val one = new Unit(Zero)
val two = new Unit(one)
val three = two.successor
val six = three + three
val four = six - two
