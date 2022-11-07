package racingcar.service

import racingcar.Car
import racingcar.strategy.ForwardStrategy

class RacingService {
    fun makeCar(count: Int) =
        (ONE..count).map { Car(strategy = ForwardStrategy()) }

    fun race(cars: List<Car>) = cars.map { it.move() }

    companion object {
        private const val ONE = 1
    }
}
