package racingcar

class Car(
    id: Int,
    currentPosition: Int = 0,
) {
    var currentPosition: Int = currentPosition
        private set

    fun move(moveStrategy: MoveStrategy) {
        if (moveStrategy.isPossibleMove()) {
            this.currentPosition += moveStrategy.getDistance()
        }
    }
}
