2 + 3 + 4

def abs(x: Double) = if (x < 0) -x else x

abs(-4)

def sqrt(x: Double) = {
  //We no longer need to pass x inside the inner function because
  //the outer definitions are visible inside the inner functions
  //unless they are shadowed
  def sqrtIter(guess: Double/*, x: Double*/): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double/*, x: Double*/) =
    abs((guess * guess) - x) / x < 0.001

  def improve(guess: Double/*, x: Double*/) =
    (guess + x / guess) / 2

  sqrtIter(1)
}

sqrt(2)
sqrt(1e-6)

abs(1e-6 * 1e-6 - 1e-6)

sqrt(0.001)

abs((0.5000005 * 0.5000005) - 1e-6)








