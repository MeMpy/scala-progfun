def isPrime(n:Integer):Boolean= (2 until n).forall( x=> n%x!=0)

def isPrime2(n:Integer):Boolean={
  (2 until n).flatMap(x => if ( n % x == 0) List(x) else Nil).isEmpty
}

isPrime(22)

def isSafe(col: Int, queens: List[Int]):Boolean = {
  if (queens.isEmpty)
    true
  else {
    ((for(x <- 1 to queens.length) yield Set(col, col+x,col-x)) zip queens).forall(
      x => !x._1.contains(x._2)
    )
  }
}

isSafe(2, List(0,0,1))


val a = List("Unix", "re")
a.mkString
