package racingcar.view

import racingcar.car.Car

object ResultView {

    private const val RACING_RESULT = "실행 결과"

    fun printResult() {
        println()
        println(RACING_RESULT)
        println()
    }

    fun printCarPositions(cars: List<Car>) {
        cars.forEach { car ->
            repeat(car.getPosition()) {
                print("-")
            }
            println()
        }
        println()
    }
}
