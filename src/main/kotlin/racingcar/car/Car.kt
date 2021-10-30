package racingcar.car

import racingcar.engine.CarEngine
import racingcar.exception.RacingCarException.READ_LINE_IS_EXCEEDED_FIVE_CHAR_EXCEPTION

data class Car(val name: String = "", private var _position: Int = 0, private var carEngine: CarEngine) {

    val position: Int
        get() = _position

    init {
        require(name.length <= 5) { READ_LINE_IS_EXCEEDED_FIVE_CHAR_EXCEPTION }
    }

    fun movePosition() {
        if (carEngine.execute()) {
            _position++
        }
    }
}
