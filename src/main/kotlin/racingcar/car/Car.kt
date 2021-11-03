package racingcar.car

import racingcar.engine.CarEngine

data class Car(val name: CarName = CarName(""), private var _position: Int = 0, private var carEngine: CarEngine) {

    val position: Int
        get() = _position

    fun movePosition() {
        if (carEngine.execute()) {
            _position++
        }
    }
}
