package racingcar

object ResultView {
    fun printSkid(distance: Int) {
        repeat(distance) {
            print("-")
        }
        println()
    }
}
