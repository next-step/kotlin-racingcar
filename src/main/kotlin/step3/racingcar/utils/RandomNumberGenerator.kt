package step3.racingcar.utils

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars

object RandomNumberGenerator {
    private const val RANGE_START = 1
    private const val RANGE_END = 9

    fun generateRandomNumberToCarByRound(cars: Cars, totalRound: Int) {
        cars.elements().forEach {
            generateRandomNumberToEachCar(it, totalRound)
        }
    }

    private fun generate(): Int = (RANGE_START..RANGE_END).random()

    private fun generateRandomNumberToEachCar(car: Car, totalRound: Int) {
        repeat(totalRound) {
            car.addRandomNumber(generate())
        }
    }
}
