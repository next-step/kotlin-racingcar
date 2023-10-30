package step4.data

import step4.domain.TryMoving

data class RacingCar(
    val name: String,
    var moveCount: Int = 0
) {
    fun tryMoving() {
        if (TryMoving.isSuccessfullyMoved()) {
            moveCount += 1
        }
    }
}
