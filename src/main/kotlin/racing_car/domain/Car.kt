package racing_car.domain

class Car(
    private val moveStrategy: MoveStrategy = RandomAboveThresholdMoveStrategy()
) {

    var position = 0
        private set

    fun move() {
        if (moveStrategy.canMove()) {
            position++
        }
    }
}
