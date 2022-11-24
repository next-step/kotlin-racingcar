package racingcar.domain

data class Car(val position: Position = Position(), val name: CarName = CarName()) : Comparable<Car> {

    fun moveByStrategy(strategy: MoveStrategy): Car {
        if (!strategy.canMove()) {
            return copy()
        }
        return move()
    }

    fun isSamePosition(other: Car) = this.position == other.position
    override fun compareTo(other: Car): Int = this.position - other.position
    private fun move() = Car(position.increase(), name)

    companion object {
        fun from(pos: Int): Car = Car(Position(pos))
        fun withNameAndPosition(name: String, position: Int) = Car(position = Position(position), name = CarName(name))
    }
}
