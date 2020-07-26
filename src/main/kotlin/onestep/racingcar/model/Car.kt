package onestep.racingcar.model

import onestep.racingcar.model.engine.CarEngine
import onestep.racingcar.model.engine.RandomCarEngine

data class Car(
    private var _position: Int = 0,
    private val engine: CarEngine = RandomCarEngine
) {
    val position: Int
        get() = _position

    fun run() {
        _position += engine.run()
    }
}
