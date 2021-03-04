package racingcar_winner.ui

import racingcar_winner.model.Cars
import racingcar_winner.util.progressNumberToBar

class Outputview {

    fun printProgressOfCars(cars: Cars){
        val progressOfCars = getProgressOfCars(cars)
        for(progressCar in progressOfCars) {
            println(progressCar)
        }
    }

    fun printWinner(cars: Cars) {
        val winners = getWinners(cars, getHighScore(cars))
        println("우승자 : ${winners.joinToString(", " )}")
    }

    private fun getProgressOfCars(cars: Cars): List<String> {
        return cars.toList().map { car ->
            "${car.name} : ${car.progress.progressNumberToBar()}"
        }
    }

    private fun getHighScore(cars: Cars): Int {
        return cars.toList().map { car ->
            car.progress
        }.max()!!
    }

    private fun getWinners(cars: Cars, highScore: Int): List<String> {
        return cars.toList().filter { car ->
            car.progress == highScore
        }.map {
            it.name
        }
    }
}