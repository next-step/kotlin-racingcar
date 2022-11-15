package racingcar

class CarRacer(private val car: Car, private val carControl: CarControl) {
    val carName: Name
        get() = car.name

    val carPosition: Position
        get() = car.position

    fun drive() {
        car.move(carControl.power())
    }
}
