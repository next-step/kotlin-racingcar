package src.racingcar.view

import src.racingcar.domain.Car
import src.racingcar.domain.Race
import src.racingcar.domain.Winner
import src.racingcar.utils.parseComma

object ResultView {
    fun printRacingCarGameResult(tryCount: Int, carNames: String) {
        val race = Race.create(parseComma(carNames))
        repeat(tryCount) {
            val raceCars = race.start()
            printRacing(raceCars)
        }

        printWinner(Winner(race.cars).findWinners())
    }

    private fun printRacing(raceCars: List<Car>) {
        for (raceCar in raceCars) {
            print(raceCar.name)
            print(" : ")
            println("-".repeat(raceCar.moveCount))
        }
        println()
    }

    private fun printWinner(findWinners: List<Car>) {
        print(findWinners.joinToString { car -> car.name })
        print("가 최종 우승 했습니다.")
    }
}
