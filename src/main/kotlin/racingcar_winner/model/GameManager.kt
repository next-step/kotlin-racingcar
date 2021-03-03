package racingcar_winner.model

import racingcar_winner.util.progressNumberToBar

class GameManager(
    cars: Cars
) {
    private val cars: List<Car> = cars.toList()

    fun getNumberOfCars(): Int = cars.size

    fun getProgressOfCars(): List<String> {
        val cars = cars.toList()
        return cars.map { car ->
            "${car.name} : ${car.progress.progressNumberToBar()}"
        }
    }

    fun getWinners(highScore: Int): List<String> {
        val cars = cars.toList()
        return cars.filter { car ->
            car.progress == highScore
        }.map {
            it.name
        }
    }

    fun getHighScore(): Int {
        val cars = cars.toList()
        return cars.map { car ->
            car.progress
        }.max()!!
    }
}