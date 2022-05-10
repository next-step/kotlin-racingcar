package racing.model

class Car(
    private val position: Position = Position(0)
) {

    fun moveForward(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            position.plusOne()
        }
    }

    fun position(): Int {
        return position.position
    }
}
