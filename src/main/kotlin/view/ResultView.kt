package view

import domain.Car

class ResultView {

    fun printRacingGame(cars: List<Car>) {
        printRacingResult(cars)
    }

    private fun printRacingResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : " + "-".repeat(it.position))
        }
        println()
    }

    fun printWinner(winners: List<Car>) {
        print(winners.joinToString { car -> car.name })
        print("가 최종 우승 했습니다.")
    }
}
