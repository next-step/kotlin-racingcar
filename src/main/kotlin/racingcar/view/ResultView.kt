package racingcar.view

import racingcar.car.Car
import racingcar.car.Winners

object ResultView {

    private const val RACING_RESULT = "실행 결과"

    fun printResult() {
        println()
        println(RACING_RESULT)
        println()
    }

    fun printCarPositions(cars: List<Car>) {
        cars.forEach { car ->
            print("${car.name} : ")
            repeat(car.position) {
                print("-")
            }
            println()
        }
        println()
    }

    fun printWinners(winners: Winners) {
        println("최종 우승자는 ${winners.winners.joinToString { it.name }}")
    }
}
