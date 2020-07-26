package onestep.racingcar.model

import onestep.racingcar.model.engine.CarEngine
import onestep.racingcar.model.engine.RandomCarEngine

data class Car(
    private var position: Int = 0,
    private val engine: CarEngine = RandomCarEngine
) {
    fun run() {
        position += engine.run()
    }

    fun printPosition(): String {
        var result = ""
        for (i in 0 until position) {
            result += "-"
        }
        return result
    }
}
