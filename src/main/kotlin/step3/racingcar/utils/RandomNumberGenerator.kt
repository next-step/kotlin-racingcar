package step3.racingcar.utils

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.RandomNumber
import step3.racingcar.domain.RandomNumber.Companion.RANGE_END
import step3.racingcar.domain.RandomNumber.Companion.RANGE_START

class RandomNumberGenerator : RandomNumber {
    override fun value(): Int = generate()

    private fun generate(): Int = (RANGE_START..RANGE_END).random()

    fun generateRandomNumberToCarByRound(cars: Cars, totalRound: Int) {
        cars.elements().forEach {
            generateRandomNumberToEachCar(it, totalRound)
        }
    }

    private fun generateRandomNumberToEachCar(car: Car, totalRound: Int) {
        repeat(totalRound) {
            car.addRandomNumber(generate())
        }
    }
}
