package racingcar

class Car(moveCount: Int = 0) {
    var moveCount = moveCount
        private set

    fun move() {
        if (RacingCarUtil.checkMoveValue(RacingCarUtil.createRandomInt())) {
            moveCount ++
        }
    }
}
