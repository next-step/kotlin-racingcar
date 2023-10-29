package racingcar

class Car {
    var position: Int = 0
        private set

    fun tryMove(moveCondition: MoveCondition) {
        if (moveCondition.canForward()) {
            position++
        }
    }
}
