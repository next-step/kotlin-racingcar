package racingCar.domain

import racingCar.domain.strategy.MoveStrategy

class Car(val name: String, moveCount: Int = 0, private val moveStrategy: MoveStrategy) {

    var moveCount: Int = moveCount
        private set

    fun move() {
        if (moveStrategy.isMove()) { ++moveCount }
    }

    fun copy(newName: String = this.name, newMoveCount: Int = this.moveCount, newMoveStrategy: MoveStrategy = this.moveStrategy): Car {
        return Car(newName, newMoveCount, newMoveStrategy)
    }
}
