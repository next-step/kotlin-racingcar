package racingcar

class Driver(private val car: Car) {
    fun drive(isMovable: Boolean) {
        if (isMovable) car.move()
    }

    fun getMoveResult(): String {
        return "-".repeat(car.movement)
    }
}