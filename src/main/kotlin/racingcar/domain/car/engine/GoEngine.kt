package racingcar.domain.car.engine

import racingcar.domain.car.Car

class GoEngine : Engine {
    override fun forward(distance: Int): Int {
        return distance + Car.ONE_SPACE
    }
}
