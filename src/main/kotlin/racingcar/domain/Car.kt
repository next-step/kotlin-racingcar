package racingcar.domain

internal class Car {
    var position = 0
        private set

    fun go(moveState: MoveState) {
        if (moveState.isMovable) {
            position++
        }
    }
}
