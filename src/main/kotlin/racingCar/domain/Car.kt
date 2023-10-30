package racingCar.domain

import racingCar.domain.strategy.MoveStrategy

class Car(val name: String, moveCount: Int = 0, private val moveStrategy: MoveStrategy) {

    var moveCount: Int = moveCount
        private set

    fun moveByStrategy() {
        if (moveStrategy.isMove()) { ++moveCount }
    }
}
