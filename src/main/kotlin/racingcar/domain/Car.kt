package racingcar.domain

class Car(
    val position: Position = Position()
) {
    fun drive(): Car {
        if (canDrive()) {
            return Car(position.change())
        }
        return this
    }

    fun canDrive(): Boolean {
        return true
    }
}
