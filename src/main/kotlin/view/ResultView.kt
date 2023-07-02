package view

import domain.Car
import controller.RacingGame
import domain.Winner

class ResultView {

    fun printRacingGame(retryCount: Int, carNames: String) {
        val race = RacingGame.create(carNames)
        repeat(retryCount) {
            printRacingResult(race.cars)
        }
        printWinner(Winner(race.cars).getWinner())
    }

    private fun printRacingResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : " + "-".repeat(it.position))
        }
        println()
    }

    private fun printWinner(winners: List<Car>) {
        print(winners.joinToString { car -> car.name })
        print("가 최종 우승 했습니다.")
    }
}
