val v = Vector(1,2,3,4)

//A vector is a sequence which has a better performance then a list
//when you need to access to a random element inside it
//also it has better performance when you apply map fold and
//similar function on it
//The drawback is that is harder to construct then a list
//So if your application needs to access recursively to the sequence
//in a list fashioned way ( head :: tail ) than use a list else a Vector
//If you application needs to modify frequently the sequence then use a list
//else a vector. For the cases in between just try :)

//This is the only difference between list and vector
// +: instead of ::
1 +: v
v :+ 1

//Other  pseudo sequence are:
val s:String = "MeMpy"
s.map(x => x.toUpper)

val arr:Array[Int] = Array(1,2,3,4)
arr.map(x => -x)

val l = List(1,2,3,4,5,6)
//zip take two sequence ( the source and the argument)
//and zip them together. The final type will be the type
//of the source sequence and the elements will be couples where
//the n element of the source is the first elem of the couple
//and the n element of the argument is the second elem of the couple
//the length will be the min(source,argument)
val lv = l zip v
val vl = v zip l

//Unzip is the counter part of zip for a list of couple.
//it unzips the list in 2 separate lists formed by the elements of the couples
//each fist element in the first list and each second element in the second.
//NB (l zip v).unzip == (l,v) only if l.size == v.size
lv.unzip
vl.unzip

//Flatmap is like map, but with 2 main differences:
// 1) for each element in the sequence apply a function
//    that returns a new TRAVERSABLE element that is an
//    other collection like list or vector (with map you
//    can return any type
// 2) after the applying of the function concatenate all the
//    element into a new sequence of the same type of the type
//    of the source
//Why use flatMap and not map, well it is useful if you have
// a function that return an iterable of size 0 or 1 like an Option
//apply flat map return a clean sequence
l.map(x => if (x>2) List() else List(x))
l.flatMap(x => if (x>2) List() else List(x))

//Range are special sequence represented by an object
//with 3 properties:
//lower bound
//upper bound
//step
//Since we have these properties we can use them to
//instantiate the object
val r = Range(1,10)
val r2 = 1 to 10 //lower to upper
val r1 = 10 to 1//lower to upper
val r3 = 1 until 10 // lower to upper - 1
val r4 = 1 to 10 by 2 // lower to upper with step 2

val v1= for(x <- 0 to 10; y <- 0 to 10 if y%2==0 ) yield x+y

val v2 = (0 to 10).flatMap( x=> (0 to 10).withFilter( y=> y%2==0).map( y => x+y))

v1 == v2

//Group by
"Stringata".groupBy(_.toLower)
"Stringata".toLowerCase.sorted.groupBy(_.toLower)


List(('a', 1), ('b', 1)) map { case (xc,xn) => xc}






