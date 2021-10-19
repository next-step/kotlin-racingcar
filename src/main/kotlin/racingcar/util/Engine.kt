package racingcar.util

import racingcar.constant.Constant
import racingcar.model.Car

object Engine {
    fun forward(car: Car) = car.copy(distance = car.distance.plus(Constant.ONE_SPACE))
}
