package racingcar.domain

import racingcar.entity.Car

private const val MOVING_NUMBER = 4
class Racing {
    fun makeCars(num: Int): List<Car> {
        return (1..num).map { Car() }
    }

    fun moveCars(cars: List<Car>) {
        cars.asSequence().forEach {
            if (randomNum() >= MOVING_NUMBER) {
                it.move(1)
            }
        }
    }

    private fun randomNum(): Int {
        return (0..9).random()
    }
}
