import org.scalatest.{FlatSpec, ShouldMatchers}

class RecursionTest extends FlatSpec with ShouldMatchers
{
  /*
   * Pascal'a triangle
   */
  "A Pascal Triangle" must "have 1 at the start and end of each row" in {
    Recursion.pascal(1,1) shouldEqual 1
    Recursion.pascal(2,2) shouldEqual 1
  }

  it should "have other elements depending on the previous row" in {
    Recursion.pascal(3,1) shouldEqual 3
    Recursion.pascal(4,2) shouldEqual 6
  }
  /*
   * Paranthesis balancing
   */

  "An expression" can "be a balanced one" in {
    Recursion.balance("()()()".toList) shouldBe true
    Recursion.balance("(another (example))".toList) shouldBe true
  }

  it can "be unbalanced too" in {
    Recursion.balance("()()(".toList) shouldBe false
    Recursion.balance("(another (bad (example ;))".toList) shouldBe false
  }

  it can "be a balanced one if there are no paranthesis at all" in {
    Recursion.balance("string without paranthesis".toList) shouldBe true
  }
  /*
   * Count change
   */
  "A specified amount" can "have several possibilities of splitting up" in {
    Recursion.countChange(4,List(1,2)) shouldEqual 3
    Recursion.countChange(6,List(1,3)) shouldEqual 3
  }
}
