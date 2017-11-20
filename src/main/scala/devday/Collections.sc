val string1: String = "Rosario"

val string2 = "Davide"

var string3 = "Marco"

string3 = "Giuseppe"

val aList = List(1, 2, 3, 4)
aList.head
aList.tail

val aStrList = aList.map( elm => elm.toString )

val aStrList2 = aList.map(_.toString)
val aStrList3 = aList map {
  _.toString()
}

val aString = aStrList.reduce{
  (a,b) => a.concat(b)
}


val aMap = Map( 1-> string1, 2 -> string2, 3 -> string3)
aMap(1)

val maybeFirstElem = aMap.get(1)
val maybeForthElem = aMap.get(4)

maybeForthElem match {
  case Some(e) => s"my name is $e"
  case None => s"no one found"
}

val myMaybes = Seq(maybeFirstElem, maybeForthElem)

myMaybes map { elem =>
   elem match {
     case Some(e) => s"my name is $e"
     case None => s"no one found"
  }
}

myMaybes map ( _.map(_.length))

for {
  myMaybe <- myMaybes
  elem <- myMaybe
} yield {
  elem.length
}
