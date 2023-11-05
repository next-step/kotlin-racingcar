package racingcar.view

object ResultView {
    fun printResult() {
        println("주행 결과")
    }

    fun printPosition(position: Int) {
         println("-".repeat(position))
    }
    fun printPositions(positions: List<Int>) {
        positions.forEach { printPosition(it) }
        println()
    }
}