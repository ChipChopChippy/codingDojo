package fizzbuzz

import org.scalatest.{FunSuite, Matchers}
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

class FizzBuzzTest extends FunSuite with Matchers {

  test("null integer should throw an error") {
    val thrown = intercept[IllegalArgumentException] {
      FizzBuzz.str(null)
    }
    assert(thrown.getMessage === "requirement failed: illegal argument can't pass null or negative number")
  }

  test("negative number should throw an error") {
    val thrown = intercept[IllegalArgumentException] {
      FizzBuzz.str(-1)
    }
    assert(thrown.getMessage === "requirement failed: illegal argument can't pass null or negative number")
  }

  test("3 should return a value of fizz") {
    FizzBuzz.str(3) should be("fizz")
  }

  test("5 should return a value of buzz") {
    FizzBuzz.str(5) should be("buzz")
  }

  test("7 should return a value of 7") {
    FizzBuzz.str(7) should be("7")
  }

  test("15 should return a value of fizzbuzz") {
    FizzBuzz.str(15) should be("fizzbuzz")
  }

  val oneToOneHundred =
    "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz fizz 22 23 fizz buzz 26 fizz 28 29 " +
      "fizzbuzz 31 32 fizz 34 buzz fizz 37 38 fizz buzz 41 fizz 43 44 fizzbuzz 46 47 fizz 49 buzz fizz 52 53 fizz buzz " +
      "56 fizz 58 59 fizzbuzz 61 62 fizz 64 buzz fizz 67 68 fizz buzz 71 fizz 73 74 fizzbuzz 76 77 fizz 79 buzz fizz 82 " +
      "83 fizz buzz 86 fizz 88 89 fizzbuzz 91 92 fizz 94 buzz fizz 97 98 fizz buzz"
  
  test("all the numbers between 1 and 100 should be correct") {
    val str = for {
      i <- 1 to 100
      res = FizzBuzz.str(i)
    } yield res
    assert(str.mkString(" ").trim === oneToOneHundred)
  }

  test ("scalacheck") {
    val smallInteger = Gen.choose(1, 100)
    val propFizz = forAll(smallInteger) { (n: Int) => FizzBuzz.str(Math.abs(n)) === "fizz" }
    propFizz.check
  }
}
