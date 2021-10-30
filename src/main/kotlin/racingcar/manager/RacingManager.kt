package racingcar.manager

import racingcar.car.Car
import racingcar.car.Cars
import racingcar.car.Winners

class RacingManager(
    private val _cars: Cars
) {

    val cars: Cars
        get() = _cars

    fun race(show: ((List<Car>) -> Unit)? = null, attempts: Int): Winners {
        repeat(attempts) {
            _cars.movePositions()
            show?.invoke(_cars.cars)
        }
        return Winners(_cars.findWinners())
    }
}
