package racingcar.manager

import racingcar.car.Car
import racingcar.car.Cars
import racingcar.car.Winners

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
