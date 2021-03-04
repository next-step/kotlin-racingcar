package racingcar.view

import racingcar.domain.Car
import racingcar.domain.CarAction

class ResultView(private val cars: List<Car>) {

    fun print() {
        println("실행 결과")
        printEachTurn()
    }

    private fun attemptCount() = cars[0].history.size

    private fun printEachTurn() {
        val currentTurn = MutableList(cars.size) { 0 }
        for (i in 0 until attemptCount()) {
            val history = cars.map { it.history[i] }
            currentTurn.forEachIndexed { index, it ->
                val moveCount = if (history[index] == CarAction.MOVE) 1 else 0
                currentTurn[index] = it + moveCount
            }
            printHistory(currentTurn)
        }
    }

    private fun printHistory(history: List<Int>) {
        history.forEach {
            for (i in 0 until it) print("-")
            println()
        }
        println()
    }
}
