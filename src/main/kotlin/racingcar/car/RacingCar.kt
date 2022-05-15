package racingcar.car

import racingcar.engine.Engine

class RacingCar(
    private val engine: Engine,
    private val position: Position = Position(0),
    private val name: String = "",
) : Car {
    override fun forward(): Car {
        val distance = engine.accelerate()
        val newPosition = Position(position.value + distance.value)

        return RacingCar(engine, newPosition)
    }

    override fun position(): Position = position

    override fun name(): String = name
}
