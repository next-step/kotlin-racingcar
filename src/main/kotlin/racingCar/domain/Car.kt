package racingCar.domain

data class Car(private var position: Position = Position()) {
    constructor(position: Int) : this(Position(position))

    fun move() {
        this.position = position.increase()
    }

    fun getPosition(): Position = position.copy()
}
