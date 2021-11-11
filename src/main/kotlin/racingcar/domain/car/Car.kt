package racingcar.domain.car

import racingcar.domain.car.engine.Engine

class Car(private val engine: Engine, val name: String = DEFAULT_NAME) {
    var distance = READY_STATUS
        private set

    fun start(): Car {
        distance = engine.forward(distance)
        return this
    }

    companion object {
        const val READY_STATUS = 0
        const val ONE_SPACE = 1
        const val DEFAULT_NAME = "NO_NAME"
    }
}
