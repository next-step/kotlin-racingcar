package onestep.racingcar.model

import onestep.racingcar.model.engine.CarEngine
import onestep.racingcar.model.engine.RandomCarEngine

data class Car(
    val name: String = "",
    private var _position: Int = 0,
    private val engine: CarEngine = RandomCarEngine
) {
    val position: Int
        get() = _position

    fun run() {
        _position += engine.run()
    }

    companion object {
        fun newInstance(name: String): Car {
            require(name.length < 5) { "CarName's Length can not more than 5" }
            return Car(name = name)
        }
    }
}
