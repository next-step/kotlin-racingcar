package step3.racing

object ResultView {
  fun showDistance(input: Long) {
    repeat(input.toInt()) { print("-") }
    println()
  }
}
