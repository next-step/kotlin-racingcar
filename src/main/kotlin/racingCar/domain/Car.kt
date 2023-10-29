package racingCar.domain

import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy

class Car(val name: String, private val moveStrategy: MoveStrategy = RandomStrategy()) {

    var moveCount: Int = 0
        private set

    fun conditionalMove() {
        val randomValue = RandomNumberGenerator.getRandomNumber()
        if (moveStrategy.isMove(randomValue)) { move() }
    }

    fun move(): Int = ++moveCount
}
