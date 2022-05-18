package racingcar

class Driver(val name: String, private val car: Car) {
    val driveRecord = mutableListOf<Int>()

    fun drive(isMovable: Boolean) {
        if (isMovable) {
            car.move()
        }
        driveRecord.add(car.movement)
    }
}
