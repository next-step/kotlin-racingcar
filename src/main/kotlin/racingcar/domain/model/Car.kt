package racingcar.domain.model

class Car(val carName: CarName, private var _position: Position) {

    val position: Position
        get() = _position

    fun moveTo(count: Int) {
        if (count >= 4) _position++
    }

    fun copy(): Car {
        return Car(carName, _position)
    }
}

