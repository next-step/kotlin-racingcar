package racingcar

class CarRacer(private val car: Car, private val carControl: CarControl) {
    val position: Position
        get() = car.position

    fun drive() {
        car.move(carControl.power())
    }
}
