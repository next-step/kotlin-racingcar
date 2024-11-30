package study.racingcar.entity

import study.racingcar.util.MoveStrategy
import study.racingcar.util.TargetGEvalidConditionMoveStrategy

class Car(carName: String, moveCount: Int = 0) {
    var currentPosition: Int = moveCount
    val name: String = carName
    var moveStrategy: MoveStrategy = TargetGEvalidConditionMoveStrategy()


    fun move(
        distance: Int,
        validCondition: Int,
    ) {
        if (moveStrategy.isMove(distance, validCondition)) {
            currentPosition++
        }
    }

    fun clone(): Car {
        return Car(name, currentPosition)
    }
}
