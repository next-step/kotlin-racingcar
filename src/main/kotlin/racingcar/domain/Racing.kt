package racingcar.domain

import racingcar.entity.Car

class Racing {
    fun makeCars(num: Int): List<Car> {
        return (1..num).map { Car("-") }
    }

    fun moveCars(cars: List<Car>) {
        cars.asSequence().forEach {
            if (randomNum() > 4) {
                move(it)
            }
        }
    }

    fun move(car: Car) {
        car.distance = car.distance + "-"
    }

    private fun randomNum(): Int {
        return (0..9).random()
    }
}
