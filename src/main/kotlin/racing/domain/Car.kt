package racing.domain

data class Car(
    val name: String,
    var position: Position = Position(),
    private val moveStrategy: MoveStrategy = RandomStrategy.instance
) {

    constructor(position: Int, moveStrategy: MoveStrategy) : this("noName", Position(position), moveStrategy)

    fun move(): Position {
        if (moveStrategy.canMove()) {
            position = position.move()
        }

        return position
    }
}
