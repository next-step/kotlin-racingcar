package racingCar.domain

import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy

class Car(val name: String) {

    var moveCount: Int = 0
        private set

    private val moveStrategy: MoveStrategy = RandomStrategy()

    fun conditionalMove() {
        val randomValue = RandomNumberGenerator.getRandomNumber()
        if (moveStrategy.isMove(randomValue)) { move() }
    }

    fun move(): Int = ++moveCount
}
