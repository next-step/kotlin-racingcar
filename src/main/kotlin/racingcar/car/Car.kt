package racingcar.car

import racingcar.engine.CarEngine

data class Car(private val _Car_name: CarName = CarName(""), private var _position: Int = 0, private var carEngine: CarEngine) {

    val position: Int
        get() = _position

    val name: String
        get() = _Car_name.name

    fun movePosition() {
        if (carEngine.execute()) {
            _position++
        }
    }
}
