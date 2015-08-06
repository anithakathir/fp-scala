
object Recursion {

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  def balance(chars: List[Char]): Boolean = {
    def checkChar(ch: Char, c: Int): Int =
      if (ch == '(') c + 1 else if (ch == ')') c - 1 else c

    def check(exp: List[Char], state: Int): Int = {

      if (exp.isEmpty) state
      else if (state == -1) -1
      else
        check(exp.tail, checkChar(exp.head, state))
    }
    if (check(chars, 0) == 0) true else false

  }

  def countChange(money: Int, coins: List[Int]): Int = {
    var numVariations = 0
    def calc(money: Int, coins: List[Int]) {
      if (coins.nonEmpty)
        if (money>coins.head) {
          calc(money-coins.head, coins)
          calc(money,coins.tail)
        }
        else if (money<coins.head) {
          calc(money,coins.tail)
        }
        else if (money-coins.head == 0) {
          numVariations += 1
        }
    }
    calc(money,coins.sorted)
    numVariations
  }
}
