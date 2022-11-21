package racingcar.domain

class Car(
    val id: Int,
    val name: CarName,
    position: Position = Position(value = 0),
) {
    var position = position
        private set

    constructor(car: Car) : this(
        id = car.id,
        name = car.name,
        position = car.position,
    )

    fun move(movePolicy: MovePolicy) {
        if (movePolicy.canMove()) {
            this.position = this.position.forward()
        }
    }
}
