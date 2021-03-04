package racingcar_winner.ui

import racingcar_winner.model.Cars
import racingcar_winner.model.Winner
import racingcar_winner.util.progressNumberToBar

class Outputview {
    private val winner = Winner()

    fun printProgressOfCars(cars: Cars){
        val progressOfCars = getProgressOfCars(cars)
        for(progressCar in progressOfCars) {
            println(progressCar)
        }
    }

    fun printWinner(cars: Cars) {
        val winners = winner.getWinner(cars)
        println("우승자 : ${winners.joinToString(", " )}")
    }

    private fun getProgressOfCars(cars: Cars): List<String> {
        return cars.toList().map { car ->
            "${car.name} : ${car.progress.progressNumberToBar()}"
        }
    }
}