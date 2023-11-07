package racingcar.domain

class Car(
    private var name: Name,
    private val movingStrategy: MovingStrategy = RandomMovingStrategy(),
    private var position: Position = Position(),
) {
    fun move() {
        if (movingStrategy.isMovable()) {
            position.forward()
        }
    }

    fun getPosition(): Position {
        return position
    }

    fun getName(): Name {
        return name
    }

    fun isWinner(winnerPosition: Position): Boolean {
        return position.equal(winnerPosition)
    }
}
