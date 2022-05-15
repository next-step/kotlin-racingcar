package racingcar.car

import racingcar.engine.Engine

class RacingCar(private val engine: Engine) : Car {
    private var position = Position(0)

    override fun forward() {
        val distance = engine.accelerate()
        position = Position(position.value + distance.value)
    }

    override fun position(): Position = position
}
