package racingcar

import racingcar.MoveType.Companion.isPossibleMove

data class Car(
    val id: Int,
    var currentPosition: Int = 0,
) {
    fun move(moveType: MoveType) {
        if (isPossibleMove(moveType)) {
            this.currentPosition += moveType.movePosition
        }
    }

    fun getCurrentLocation(): Int {
        return currentPosition
    }
}
