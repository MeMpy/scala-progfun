/***
  * Future is the way scala provides async computation
  * It is very powerful. It acts like the event programming paradigm
  * using onComplete and onSuccess OnFailure to handle the completition
  * of the async operations. But these methods cannot be chained because
  * they return Void.
  * But because of the nature of a Future class it can be used like a collection
  * so you can chain multiple future call using map of for comprehension
  * because the result returned is something like an Option case class [Try case class
  *
  */

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

def fun(l:List[String]) = println("fun"+l.mkString)
def fun2(l:List[String]) = println("fun2"+l.reverse.mkString)

val f = Future[List[String]] {
  Thread.sleep(2000)
  for(x <- List(1 to 10)) yield x.toString
}
f.onComplete {
  case Success(e) => fun(e)
  case Failure(ex) => println(ex.getMessage)
}

f.onSuccess {
  case x => fun2(x)
}

f.onFailure {
  case ex => println("again!")
}

for(x <- List(10 to 20)) yield x.toString

val d = Duration(5, duration.SECONDS)
//If a thread ( the main in this case ) wants to wait for a
//future it must use Await.
Await.result(f, d)
