package racingcar.view

import racingcar.model.Car

private const val ONE_BLOCK = "-"
private const val SEPARATOR = " | "

class ResultView(private val car: Car) {
    fun printResult() {
        printName(car)
        printScore(car)
    }

    private fun printName(car: Car) {
        print(car.name)
        print(SEPARATOR)
    }

    private fun printScore(car: Car) {
        for (i in 1..car.score) {
            print(ONE_BLOCK)
        }
        println()
    }
}
