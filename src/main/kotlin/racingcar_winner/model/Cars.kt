package racingcar_winner.model

import racingcar_winner.util.progressNumberToBar

class Cars(
    cars: List<Car>
) {
    private val cars: List<Car> = cars.toList()

    fun getNumberOfCars(): Int = cars.size

    fun moveAll(randomNumberFactory: RandomNumberManager) {
        for (car in cars) {
            val randomNumber = randomNumberFactory.generateRandomNumber()
            car.tryToMoveForward(randomNumber)
        }
    }

    fun getProgressOfCars(): List<String> {
        val cars = cars.toList()
        return cars.map { car ->
            "${car.name} : ${car.progress.progressNumberToBar()}"
        }
    }

    fun getWinners(): List<String> {
        val cars = cars.toList()
        val highScore = getHighScore()

        return cars.filter { car ->
            car.progress == highScore
        }.map {
            it.name
        }
    }

    private fun getHighScore(): Int {
        val cars = cars.toList()
        return cars.map { car ->
            car.progress
        }.max()!!
    }

    override fun toString(): String {
        return cars.joinToString { car -> car.name }
    }
}
