package racingCar.domain.strategyImpl

import racingCar.domain.strategy.MoveStrategy

class RandomStrategy : MoveStrategy {

    override fun isMove(randomValue: Int): Boolean = randomValue >= FILTER_NUMBER

    companion object {
        private const val FILTER_NUMBER = 4
    }
}
