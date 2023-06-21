package presentation.view

import domain.Car
import domain.RacingGame
import domain.Winner

class ResultView {

    fun printRacingGame(retryCount: Int, carNames: String) {
        val race = RacingGame.create(carNames) { (0..9).random() }
        repeat(retryCount) {
            printRacingResult(race.start())
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
