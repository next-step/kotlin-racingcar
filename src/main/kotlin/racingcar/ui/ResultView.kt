package racingcar.ui

import racingcar.model.Car

object ResultView {

    private const val RESULT_INTRO_RESOURCE = "실행결과"

    fun printIntro() = println(RESULT_INTRO_RESOURCE)

    fun printResult(cars: List<Car>) {
        cars.forEach { car -> println(car.track) }
        println()
    }
}
