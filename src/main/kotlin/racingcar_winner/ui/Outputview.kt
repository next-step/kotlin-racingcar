package racingcar_winner.ui

import racingcar_winner.model.Cars
import racingcar_winner.util.progressNumberToBar

class Outputview {

    fun printOneRoundProgress(cars: Cars) {
        val listOfCars = cars.toList()
        for (car in listOfCars) {
            println("${car.name} : ${car.progress.progressNumberToBar()}")
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("우승자 : ${winners.joinToString(", ")}")
    }
}
