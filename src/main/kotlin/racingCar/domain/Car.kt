package racingCar.domain

data class Car(var position: Position = Position(), val name: CarName = CarName()) : Comparable<Car> {

    fun moveByStrategy(strategy: MoveStrategy): Car {
        if (!strategy.canMove()) {
            return copy()
        }
        move()
        return copy()
    }

    fun isSamePosition(other: Car) = this.position == other.position
    override fun compareTo(other: Car): Int = this.position - other.position
    private fun move() {
        this.position = position.increase()
    }

    companion object {
        fun from(pos: Int): Car = Car(Position(pos))
        fun withNameAndPosition(name: String, position: Int) = Car(position = Position(position), name = CarName(name))
    }
}
