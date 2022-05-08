package racing.model

class Car(
    private val position: Position = Position(0)
) {

    fun moveForward(carMovingStrategy: MovingStrategy) {
        if (carMovingStrategy.isMovable()) {
            position.plusOne()
        }
    }

    fun position(): Int {
        return position.position
    }
}
