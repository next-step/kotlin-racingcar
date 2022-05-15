package racingcar.car

import racingcar.engine.Engine

class Car(private val engine: Engine) {
    private var position = Position(0)

    fun forward() {
        val distance = engine.accelerate()
        position = Position(position.value + distance.value)
    }

    fun position(): Position = position
}
