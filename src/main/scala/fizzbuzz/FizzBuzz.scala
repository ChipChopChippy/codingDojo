package fizzbuzz

object FizzBuzz {
  def str(n: Integer): String = {
    require(n != null && n > 0, "illegal argument can't pass null or negative number")
    (n % 3, n % 5) match {
      case (0, 0) => "fizzbuzz"
      case (0, _) => "fizz"
      case (_, 0) => "buzz"
      case _ => n.toString
    }
  }

}
