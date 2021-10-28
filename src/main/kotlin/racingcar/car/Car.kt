package racingcar.car

import racingcar.engine.Engine

class Car(private val engine: Engine) {
    private var distance = READY_STATUS

    fun start(): Car {
        distance = engine.forward(distance)
        return this
    }

    fun getLocation(): String {
        return distance
    }

    companion object {
        const val READY_STATUS = ""
    }
}
