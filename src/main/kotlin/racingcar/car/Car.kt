package racingcar.car

import racingcar.constant.Constant
import racingcar.engine.Engine

class Car(private val engine: Engine) {
    private var distance = Constant.READY_STATUS

    fun start(): Car {
        distance = engine.forward(distance)
        return this
    }

    fun getLocation(): String {
        return distance
    }
}
