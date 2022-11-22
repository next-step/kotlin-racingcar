package racingcar.ui

import racingcar.domain.Car
import racingcar.domain.RacingGame

object ResultView {

    fun printResult(racingGame: RacingGame, count: Int) {
        println("실행결과")
        println()

        var result = racingGame
        repeat(count) {
            result = result.racing()
            printCarsPosition(result)
            println()
        }

        println(result.awardsCars().toString() + "가 최종 우승했습니다.")
    }

    private fun printCarsPosition(racingGame: RacingGame) {
        racingGame.value.forEach { car ->
            print("${car.name} : ")
            printCarState(car)
            println()
        }
    }

    private fun printCarState(car: Car) {
        repeat(car.position.value) {
            print("-")
        }
    }

}