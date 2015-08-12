

object ScrabbleInit {

  def initPointsMap(): Map[Char, Int] =
  {
    var charPointsMap = Map[Char, Int]()

    charPointsMap += ('a' -> 1)
    charPointsMap += ('b' -> 3)
    charPointsMap += ('c' -> 3)
    charPointsMap += ('d' -> 2)
    charPointsMap += ('e' -> 1)
    charPointsMap += ('f' -> 4)
    charPointsMap += ('g' -> 2)
    charPointsMap += ('h' -> 4)
    charPointsMap += ('i' -> 1)
    charPointsMap += ('j' -> 8)
    charPointsMap += ('k' -> 5)
    charPointsMap += ('l' -> 1)
    charPointsMap += ('m' -> 3)
    charPointsMap += ('n' -> 1)
    charPointsMap += ('o' -> 1)
    charPointsMap += ('p' -> 3)
    charPointsMap += ('q' -> 10)
    charPointsMap += ('r' -> 1)
    charPointsMap += ('s' -> 1)
    charPointsMap += ('t' -> 1)
    charPointsMap += ('u' -> 1)
    charPointsMap += ('v' -> 4)
    charPointsMap += ('w' -> 4)
    charPointsMap += ('x' -> 8)
    charPointsMap += ('y' -> 4)
    charPointsMap += ('z' -> 10)

    charPointsMap

  }

  def initScrabbleBoard(): Array[15,15] =
  {
    var scrabbleBoard = Array.ofDim(15, 15)

    for (i <- 0 to 14)
      for(j <- 0 to 14)
        {
          scrabbleBoard(i)(j) = j
        }

    scrabbleBoard
  }

}
