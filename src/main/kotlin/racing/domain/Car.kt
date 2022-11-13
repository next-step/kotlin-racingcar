package racing.domain

data class Car(var position: Position = Position(), private val moveStrategy: MoveStrategy = RandomStrategy.instance) {

    constructor(position: Int, moveStrategy: MoveStrategy) : this(Position(position), moveStrategy)

    fun move(): Position {
        if (moveStrategy.canMove()) {
            position = position.move()
        }

        return position
    }
}
