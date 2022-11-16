package racing.domain

data class Car(
    val name: Name,
    var position: Position = Position(),
    private val moveStrategy: MoveStrategy = RandomStrategy.instance
) {
    constructor(name: String, moveStrategy: MoveStrategy) : this(Name(name), moveStrategy = moveStrategy)
    constructor(position: Int, moveStrategy: MoveStrategy) : this(Name("racer"), Position(position), moveStrategy)

    fun move(): CarInfo {
        if (moveStrategy.canMove()) {
            position = position.move()
        }
        return CarInfo(name, position)
    }
}
