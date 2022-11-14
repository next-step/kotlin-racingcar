package fixture

import racingcar.strategy.CarMoveStrategy

class TestCarMoveStrategy(
    private val generateValue: Int,
) : CarMoveStrategy {
    override fun generate(): Int = generateValue
}
