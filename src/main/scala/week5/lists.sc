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

val dueList = unaList ++ List(1,5,6) ++ unaList
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
  case ( x :: xs, (num2,char2)) => List(x, num2) ::: xs
}

dueList
//Remove first n elem
dueList.drop(5)
//Remove the elements after the fifth
dueList.take(5)
//Apply a func to each element and return another type of elem
val coppieList = dueList.map(a => (a, a % 2 == 0))
//map function returns a collection of type equal of the type of the caller
//if you call map on a list it will return a list of B
//if you call map on a map it will return a map of B
val mappa = Map(
  1 -> "a",
  2 -> "b",
  3 -> "c"
)

mappa.map(
  f => (f._2, f._1)
)


val (list1,list2) = dueList.splitAt(4)
//Until the condition is true put elements in the first list else put al the rest in the others
dueList.span(p=> p<=3)
//like span but it covers the whole list
dueList.partition(p=> p<=3)
//basically return the first list of span
dueList.takeWhile(p=> p<=3)
//basically return the second list of span
dueList.dropWhile(p=> p<=3)
dueList(dueList.indexWhere(a => a/4 !=0))

//Apply a reduction to each element and return a single element as result of the reduction
coppieList.reduce((a1,a2) => if(a1._1 > a2._1) (a2._1, a2._2) else (a1._1, a1._2))
coppieList.reduce((a1,a2) => (a1._1 + a2._1, a1._2 | a2._2))
//the elements are elaborated as if there was an operator between each element
dueList.reduceLeft((x,y) => x+(y*2)) //dueList(0)+dueList(1) +   ... + dueList(n-1) + dueList(n)
dueList.foldLeft(10)((x,y) => x+(y*2))
// =
(10 :: dueList).reduceLeft((x,y) => x+(y*2))

val l = List("aaa", "bbb", "ccc")
l.reduce((x,y)=> x.concat(y))

for(x <- unaList; y <- dueList if (x+y)>3) yield (x,y)
val yieldList = for(x <- unaList; y <- dueList) yield (x,y)
for(x <- unaList; y <- dueList  ) yield if (x!=y) List(x,y) else None

//apply on a map
mappa(1)
//minus on a map
mappa - 1
//minus between collections
mappa -- List(1, 2, 4)
//updates
val mappa2 = mappa + (4 -> "d")
//updates between maps
mappa ++ mappa2