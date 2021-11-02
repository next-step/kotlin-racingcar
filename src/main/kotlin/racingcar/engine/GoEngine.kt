package racingcar.engine

import racingcar.car.Car

class GoEngine : Engine {
    override fun forward(distance: Int): Int {
        return distance + Car.ONE_SPACE
    }
}
