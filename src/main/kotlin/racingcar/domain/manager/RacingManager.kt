package racingcar.domain.manager

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.car.Winners

class RacingManager(
    val cars: Cars
) {


    fun race(show: ((List<Car>) -> Unit)? = null, attempts: Int): Winners {
        repeat(attempts) {
            cars.movePositions()
            show?.invoke(cars.cars)
        }
        return Winners(cars.findWinners())
    }
}
