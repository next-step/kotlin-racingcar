package racing.ui

import racing.Car

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
            convertPrintValue(carPosition[i])
        }
        println()
    }

    private fun convertPrintValue(position: Int) {
        val printValue = StringBuilder()
        repeat(position) {
            printValue.append("-")
        }
        println(printValue)
    }
}
