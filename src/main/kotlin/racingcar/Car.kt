package racingcar

import racingcar.MoveType.Companion.isPossibleMove

data class Car(
    val id: Int,
    private var _currentPosition: Int = 0,
) {
    var currentPosition: Int = _currentPosition
        private set

    fun move(moveType: MoveType) {
        if (isPossibleMove(moveType)) {
            this.currentPosition += moveType.movePosition
        }
    }
}
