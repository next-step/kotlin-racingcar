package step3

import step3.domain.strategy.MoveStrategy
import step3.domain.strategy.RandomMoveStrategy

object Configuration {
    fun moveStrategy(): MoveStrategy {
        return RandomMoveStrategy
    }
}
