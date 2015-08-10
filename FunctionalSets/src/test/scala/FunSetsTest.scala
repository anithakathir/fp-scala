
import FunSets._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunSetsTest extends FunSuite {

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

    val s = Set(1,2,3)
    val t = Set(2,3,4)
    val p = Set(2,3)
  }

  test("singletonSet(1) contains 1")
  {
    new TestSets
    {
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val u = union(s1, s2)
      assert(contains(u, 1))
      assert(contains(u, 2))
      assert(!contains(u, 3))
    }
  }

  test("intersection contains common elements of both sets") {
  new TestSets {
    val i = intersect(s, t)
    assert(contains(i, 2))
    assert(contains(i, 3))
    assert(!contains(i, 1))
    assert(!contains(i, 4))
    }
  }

  test("diff contains elements of s that are not in t ") {
  new TestSets {
    val d = diff(s, t)

    assert(contains(d, 1))
    assert(!contains(d, 2))
    }
  }

  test("p is a subset of s") {
    new TestSets {

      assert(contains(filter(s, p), 3))
    }
  }
    test("all bounded integers within s satisfy p") {
      new TestSets {
        assert(!forall(s + 1002,p))
      }
    }

    test("s has a bounded integer that satisfies p") {
      new TestSets {
        assert(exists(s,p))
      }
    }

    test("each element of s is applied a function") {
      new TestSets {
        def fun(a:Int):Int = {
          a+2
        }
        assert(contains(map(s,fun),5))
        assert(!contains(map(s,fun),6))

      }
    }

}
