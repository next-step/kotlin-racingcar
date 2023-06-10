package racingcar.domain

internal class Car {
    var position = 0
        private set

    fun go(moveCondition: MoveCondition) {
        if (moveCondition.isMovable()) {
            position++
        }
    }
}
