package racingcar.view

import racingcar.model.Car

private const val ONE_BLOCK = "-"
private const val SEPARATOR = " | "
private const val LINE_SEPARATOR = "=============================≠"

class ResultView() {
    companion object {
        fun printResults(cars: List<Car>) {
            cars.forEach { car ->
                run {
                    printName(car)
                    printScore(car)
                }
            }
            println(LINE_SEPARATOR)
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
}
