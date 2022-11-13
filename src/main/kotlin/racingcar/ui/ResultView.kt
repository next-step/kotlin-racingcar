package racingcar.ui

import racingcar.model.Car
import racingcar.model.Owner

object ResultView {

    private const val INTRO_RESOURCE = "실행결과"
    private const val WINNER_RESOURCE = "가 최종 우승했습니다."

    fun printIntro() = println(INTRO_RESOURCE)

    fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            if (car is Owner) {
                print("${car.name} : ")
            }
            println(car.track)
        }
        println()
    }

    fun printWinner(winner: List<String>) {
        println(winner.joinToString() + WINNER_RESOURCE)
    }
}
