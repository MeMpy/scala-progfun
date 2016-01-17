import scala.annotation.tailrec

//Direct recursion version
def factorial(n:Int):Int =
  if (n==0) 1 else (n*(factorial(n-1)))

factorial(20)

//Tail recursion one. It corresponds to a simple loop
//written in recursive fashion. A tail recursion function
//basically is a recursive function that don't do backtracking
//that is the last action that the function performs is a call
//to a function (also itself).
//In this way one can optimize the recursion calls using always the
//same stack trace because we do not need backtracking. In scala we
//have @tailrec that tells to the compiler that the loop function is
//tail recursive so it can apply its optimization (be aware that not
//all the language can apply optimization on tail recursive function)
def factorialTail(n:Int) = {
  @tailrec
  def loop(acc:Int, n:Int): Int =
    if (n == 0) acc
    else loop((acc*n), n-1)
  loop(1,n)
}

//In the factorial case it is not worth to implement a recursive tail f.
//because the stack trace will be always very low because the factorial value
//grows very fast. On the other hand if we have a huge stack trace it's better
// to convert a recursive f. in a tail recursive f. if we can
//In general remember that:
//Premature optimization is the root of all evil (Donald Knuth)

factorialTail(20)
