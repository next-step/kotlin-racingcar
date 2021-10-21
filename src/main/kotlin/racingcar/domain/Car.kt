package racingcar.domain

class Car(
    private val position: Position = Position(0),
    private val movingStrategy: MovingStrategy = RandomMovingStrategy()
) {

    fun getPosition(): Int {
        return this.position.value
    }

    fun dashOver(): Car {
        if (movingStrategy.ableMove()) return newCar(1)
        return this
    }

    private fun newCar(movePos: Int): Car {
        return Car(position.move(movePos))
    }
}
