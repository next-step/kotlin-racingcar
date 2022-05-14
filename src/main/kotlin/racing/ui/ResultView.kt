package racing.ui

import racing.model.CarPositionHistory

class ResultView(private val carPositionHistory: CarPositionHistory, private val times: Int) {
    fun printResult() {
        printFirst()
        repeat(times) {
            printCarPosition(it)
        }
    }

    private fun printFirst() = println("실행 결과")

    private fun printCarPosition(index: Int) {
        carPositionHistory.forEach { _, positionHistory ->
            println(PRINT_VALUE.repeat(positionHistory.getPosition(index)))
        }

        println()
    }

    companion object {
        private const val PRINT_VALUE = "-"
    }
}
