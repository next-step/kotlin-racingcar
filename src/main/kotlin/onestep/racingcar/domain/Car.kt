package onestep.racingcar.domain

import onestep.racingcar.domain.engine.CarEngine
import onestep.racingcar.domain.engine.RandomCarEngine

data class Car(
    val name: String = "",
    private var _position: Int = DEFAULT_POSITION,
    private val engine: CarEngine = RandomCarEngine
) {
    val position: Int
        get() = _position

    fun run() {
        _position += engine.run()
    }

    override fun toString() = "$name :${makePositionString()}"

    private fun makePositionString() = (1..position).joinToString("") { CAR_POSITION }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val CAR_POSITION = "-"
        fun newInstance(name: String): Car {
            require(name.length < 5) { "CarName's Length can not more than 5" }
            return Car(name = name)
        }
    }
}
