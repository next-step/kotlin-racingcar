package carGame

import carGame.domain.strategy.MoveStrategy
import carGame.domain.strategy.RandomMoveStrategy

object Configuration {
    fun moveStrategy(): MoveStrategy {
        return RandomMoveStrategy
    }
}
