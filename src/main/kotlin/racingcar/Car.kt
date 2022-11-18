package racingcar

class Car(moveCount: Int = 0) {
    var moveCount = moveCount
        private set

    fun move(moveNumber: Int) {
        if (RacingCarUtil.checkMoveValue(moveNumber)) {
            moveCount ++
        }
    }
}
