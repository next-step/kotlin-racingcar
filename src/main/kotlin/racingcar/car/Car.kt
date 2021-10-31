package racingcar.car

import racingcar.constant.Constant
import racingcar.engine.Engine

class Car(private val engine: Engine, val name: String = DEFAULT_NAME) {
    private var distance = READY_STATUS

    fun start(): Car {
        distance = engine.forward(distance)
        return this
    }

    fun getLocation(): String {
        var location = Constant.EMPTY
        repeat(distance) { location += DISTANCE_CHARACTER }
        return location
    }

    companion object {
        const val READY_STATUS = 0
        const val ONE_SPACE = 1
        const val DEFAULT_NAME = "NO_NAME"
        const val DISTANCE_CHARACTER = "-"
    }
}
