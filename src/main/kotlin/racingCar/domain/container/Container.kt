package racingCar.domain.container

import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy

object Container {
    private val moveStrategy: MoveStrategy = RandomStrategy()

    fun getMoveStrategy(): MoveStrategy {
        return moveStrategy
    }
}
