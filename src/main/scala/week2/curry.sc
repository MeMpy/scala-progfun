//This is an Higher Order Function
def sum(f: Int => Int, a:Int, b:Int):Int = {
  if(a>b) 0
  else
    f(a) + sum(f,a+1, b)
}
sum((a:Int)=>a,1,10)

sum(a=>a,1,10)

def sumTail(f:Int => Int, a:Int, b:Int)={
  def loop(a:Int, acc:Int): Int ={
    if(a>b) acc
    else
      loop(a+1, acc+ f(a))
  }
  loop(a+1,f(a))
}

sumTail((a:Int)=>a,1,10)

//CURRYING
//The type (NOT THE RETURN TYPE)
// of this function is
// Int=>Int=>(Int,Int=>Int)
//Since the function evaluation are associative
//to the right we can avoid to use the parenthesis
def sumF(f:Int=>Int):(Int,Int)=>Int={
  def internF(a:Int, b:Int):Int={
    if(a>b) 0
    else
      f(a) + internF(a+1,b)
  }
  internF
}

//We do two function call, the second one is an
//anonymous function
//The goal to use this particular way to define
//High level function is because in that way we can
//call the first function and store the result (a function)
//for later use
sumF(a=>a)(1,10)

//Syntactic sugar (Currying)
//This can be read in this way:
//The function sumFSugar return a function, that
//accepts as parameters 2 integer and return an
//integer, and internally use the function that
//you provide by invoking it.
//In this way is simple to compose function with
//multiple function parameters.
//You actually write only the last block, the
//other anonymous function will be provided
//at call time
def sumFSugar(f:Int=>Int)(a:Int,b:Int):Int={
  if(a>b)0 else f(a) + sumFSugar(f)(a+1,b)
}

sumFSugar(a=>a)(1,10)


def product(f:Int=>Int)(a:Int,b:Int):Int={
  if(a>b) 1 else f(a) * product(f)(a+1,b)
}

def factorial(n:Int):Int={
  if (n==0) 1 else n*factorial(n-1)
}

factorial(5)
product(a=>a)(1,5)
//we can also define factorial in term of product
def fact(n:Int)= product(a=>a)(1,n)

fact(5)

def god(operator:(Int,Int)=>Int, zero:Int)(f:Int=>Int)(a:Int,b:Int):Int={
  if(a>b) zero else operator(f(a),god(operator,zero)(f)(a+1,b))
}

god((a,b)=>a*b,1)(a=>a)(1,5)
god((a,b)=>a+b,0)(a=>a)(1,10)
