import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetTest extends FunSuite {
  trait TestSets {
    val tweetSet1 = new Empty
    val tweetSet2 = tweetSet1.incl(new Tweet("mashable", "5 Mobile Photographers Capturing the World With #Android http://t.co/786NneBt", 78))
    val tweetSet3 = tweetSet2.incl(new Tweet("TechCrunch", "Startup Success Requires The Drive For Data http://t.co/Yl2JpFCI by @jeffma", 78))
    val tweetSet4 = tweetSet3.incl(new Tweet("gizmodo", "The weirdest thing people hate about the iPhone 5: http://t.co/GMwuRp8D", 202))
    val tweetSet5 = tweetSet4.incl(new Tweet("engadget", "Google optimizes Flight Search for tablets, makes booking trips easier -  http://t.co/HufiiXw2", 29))

  }

  def tweets(tweet: TweetSet): Set[Tweet] = {
    var r = Set[Tweet]()
    tweet.foreach(r += _)
    r
  }

  def size(set: TweetSet): Int = tweets(set).size

  test("Filter on empty set") {
    new TestSets {
      assert(size(tweetSet1.filter(tw => tw.user == "mashable")) === 0)
    }
  }

  test("Filter on a non-empty set") {
    new TestSets {
      assert(size(tweetSet5.filter(tw => tw.user == "mashable")) === 1)
      assert(size(tweetSet5.filter(tw => tw.retweets == 78)) === 2)
    }
  }

  test("Union of two non-empty tweetsets") {
    new TestSets {
      assert(size(tweetSet4.union(tweetSet5)) === 3)
    }
  }

  test("Union with empty tweetset") {
    new TestSets {
      assert(size(tweetSet5.union(tweetSet1)) === 4)
      assert(size(tweetSet1.union(tweetSet5)) === 4)
    }
  }

  test("Most retweeted tweets") {
    new TestSets {
      val trending = tweetSet5.descendingByRetweet
      assert(!trending.isEmpty)
      //Max gizmodo with 202 retweets
      assert(trending.head.user == "gizmodo")
      //Next - mashable and TechCrunch with 78 retweets each
      assert(trending.tail.head.user == "mashable" || trending.tail.head.user == "TechCrunch")

    }
  }

}