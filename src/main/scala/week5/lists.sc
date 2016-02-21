def lastC[T](xs:List[T]):T = xs match {
  case List() => throw new NoSuchElementException
  case List(x) => x
  case _ :: ys => lastC(ys)
}


val unaList = List(1, 2 ,3 )

lastC(unaList)

unaList.init

def initC[T](xs: List[T]):List[T] = xs match {
  case List() => throw new NoSuchElementException
  case List(x) => List()
  case x :: ys => x :: initC(ys)
}

initC(unaList)

unaList ++ List(4,5,6) ++ unaList
unaList ::: List(4,5,6) ::: unaList

def removeAt[T](n: Int, xs: List[T]):List[T] = xs match {
  case List() => throw new IndexOutOfBoundsException
  case x :: ys => if(n == 0) ys else x :: removeAt(n-1, ys)
}

removeAt(0,unaList)
removeAt(1,unaList)
removeAt(2,unaList)

val unaTupla = (0, 'c')
unaTupla._1
unaTupla._2

//pattern matching per tuple
val (num, char) = unaTupla

(unaList, unaTupla) match {
  case ( x :: xs, (num,char)) => List(x, num) ::: xs
}

