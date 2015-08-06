/*
 * Created by indix on 6/8/15.
 */
object RecursionMain {
  def main(args: Array[String]) {

    /*
     * Pascal tirangle
     */
    println("******************\nPascal's triangle\n******************")
    println("Enter the number of rows for Pascal's Triangle : ")
    val numRows = io.StdIn.readInt()
    println("Pascal's Triangle of " + numRows + "rows :")
    for (row <- 0 to numRows - 1) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    /*
     * Balancing paranthesis
     */
    println("******************\nParanthesis balancing\n******************")
    println("Enter the expression to be checked for paranthesis balancing : ")
    val expression = io.StdIn.readLine()
    if(balance(expression.toList))
      println("The expression is balanced!")
    else
      println("Oops! The expression isn't balanced!")

    /*
     * Count change
     */
    println("******************\nCount change\n******************")
    println("Enter the amount : ")
    val amount = io.StdIn.readInt()
    println("Enter the list of coins available : ")

    val coins = io.StdIn.readLine()
    val coinsArray: Array[Int] = coins.split(" ").map(_.toInt)

    val change = countChange(amount,coinsArray.toList)
    println("Number of options : "+change)
  }

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
