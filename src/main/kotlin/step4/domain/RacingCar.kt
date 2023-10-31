package step4.domain

data class RacingCar(
    val carName: CarName,
    var moveCount: Int = 0
) {
    fun tryMoving(moveStrategy: MoveStrategy) {
        if (moveStrategy.isMoveSuccess()) {
            moveCount += 1
        }
    }
}
