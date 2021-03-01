package racingcar.view

import racingcar.model.Car

private const val ONE_BLOCK = "-"
private const val SEPARATOR = " | "

class ResultView(private val car: Car) {
    fun printResult() {
        print(car.name)
        print(SEPARATOR)

        for (i in 1..car.score) {
            print(ONE_BLOCK)
        }

        println()
    }
}
