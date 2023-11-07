package racingcar.domain

class Car(
    val name: Name,
    val position: Position = Position(),
    private val movingStrategy: MovingStrategy = RandomMovingStrategy(),
) {
    fun move() {
        if (movingStrategy.isMovable()) {
            position.forward()
        }
    }

    fun isWinner(winnerPosition: Position): Boolean {
        return position.equal(winnerPosition)
    }
}
