package racingCar.domain

data class Car(var position: Position = Position()) {
    constructor(position: Int) : this(Position(position))

    fun move() {
        this.position = position.increase()
    }

    fun isSamePosition(position: Position): Boolean = this.position == position
}
