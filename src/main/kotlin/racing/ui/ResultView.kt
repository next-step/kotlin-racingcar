package racing.ui

import racing.domain.Car

class ResultView(private val carPositionHistory: LinkedHashMap<Car, MutableList<Int>>, private val times: Int) {
    fun printResult() {
        printFirst()
        repeat(times) {
            printCarPosition(it)
        }
    }

    private fun printFirst() = println("실행 결과")

    private fun printCarPosition(i: Int) {
        carPositionHistory.forEach { (_, carPosition) ->
            println(PRINT_VALUE.repeat(carPosition[i]))
        }
        println()
    }

    companion object {
        const val PRINT_VALUE = "-"
    }
}
