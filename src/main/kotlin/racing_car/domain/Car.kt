package racing_car.domain

class Car(
    position: Int = 0,
    private val moveStrategy: MoveStrategy = RandomAboveThresholdMoveStrategy(),
) {

    var position: Int = position
        private set

    fun move() {
        if (moveStrategy.canMove()) {
            position++
        }
    }

    fun copy(): Car {
        return Car(position = position, moveStrategy = moveStrategy)
    }
}
