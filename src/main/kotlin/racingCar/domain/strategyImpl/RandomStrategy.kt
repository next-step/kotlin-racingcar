package racingCar.domain.strategyImpl

import racingCar.domain.strategy.MoveStrategy
import kotlin.random.Random

class RandomStrategy : MoveStrategy {

    override fun isMove(): Boolean = Random.nextInt(LIMIT_NUMBER) >= FILTER_NUMBER

    companion object {
        private const val LIMIT_NUMBER = 10
        private const val FILTER_NUMBER = 4
    }
}
