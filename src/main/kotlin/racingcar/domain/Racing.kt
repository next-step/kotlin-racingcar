package racingcar.domain

import racingcar.entity.Car

private const val MOVING_NUMBER = 4
class Racing {

    fun makeCars(name: List<String>): List<Car> {
        return name.map { Car(it) }
    }

    fun moveCars(cars: List<Car>) {
        cars.asSequence().forEach {
            if (randomNum() >= MOVING_NUMBER) {
                it.move(1)
            }
        }
    }

    fun findWinner(cars: List<Car>): List<Car> {
        val maxLength = cars.maxByOrNull { it.distance }!!.distance.length
        return cars.filter { it.distance.length == maxLength }
    }

    private fun randomNum(): Int {
        return (0..9).random()
    }
}
