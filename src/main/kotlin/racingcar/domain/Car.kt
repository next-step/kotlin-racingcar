package racingcar.domain

class Car(
    private val movingStrategy: MovingStrategy,
    private var position: Position,
    private var name: Name,
) {
    constructor(name: Name) : this(RandomMovingStrategy(), Position(), name)

    constructor(name: Name, movingStrategy: MovingStrategy) : this(movingStrategy, Position(), name)

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
