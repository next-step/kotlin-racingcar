package racingcar.model.impl

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.MoveFactor

class CarsImpl(override val value: List<Car>) : Cars {
    override fun move(random: () -> MoveFactor) {
        value.forEach { car -> car.move(random()) }
    }

    override fun carsInLead(): Cars {
        val winnerPosition = value.maxOf { car -> car.position.value }
        return CarsImpl(value.filter { car -> car.position.value == winnerPosition })
    }
}
