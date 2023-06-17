package presentation.view

import domain.Car
import domain.RacingGame
import domain.Winner

class ResultView {
    private val inputView = InputView()
    private val cars = inputView.inputCarNames().split(",").map {
        Car(it, 0)
    }

    fun start() {
        val retryCount = inputView.inputRetryCount()

        val race = RacingGame(cars)
        repeat(retryCount) {
            race.racing()
            printRacingResult(race.getCars())
        }
        printWinner()
    }

    private fun printRacingResult(cars: List<Car>) {
        cars.map {
            println("${it.name} : " + "-".repeat(it.position))
        }
        println()
    }

    private fun printWinner() {
        val result = Winner(cars).getWinner()
        println(result + "가 최종 우승했습니다.")
    }
}
