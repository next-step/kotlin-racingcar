package racingcar.car

import racingcar.engine.CarEngine

data class Car(private val _carName: CarName = CarName(""), private var _position: Int = 0, private var carEngine: CarEngine) {

    val position: Int
        get() = _position

    val name: String
        get() = _carName.name

    fun movePosition() {
        if (carEngine.execute()) {
            _position++
        }
    }
}
