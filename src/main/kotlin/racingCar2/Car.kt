package racingCar2

class Car(
    private val _name: String,
    private val _position: Int
) {
    val name: String get() = _name
    val position: Int get() = _position
}
