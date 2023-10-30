package step4.domain

class RacingCar(
    val name: String,
    var moveCount: Int = 0
) {
    fun tryMoving() {
        if (TryMoving.isSuccessfullyMoved()) {
            moveCount += 1
        }
    }
}
