package racing.domain

data class Car(
    val name: Name,
    var position: Position = Position(),
    private val moveStrategy: MoveStrategy = RandomStrategy.instance
) {
    constructor(name: String) : this(Name(name))
    constructor(position: Int, moveStrategy: MoveStrategy) : this(Name("racer"), Position(position), moveStrategy)

    fun move(): Position {
        if (moveStrategy.canMove()) {
            position = position.move()
        }

        return position
    }
}
