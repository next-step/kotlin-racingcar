package racingcar.car

import racingcar.engine.CarEngine
import racingcar.engine.RacingCarEngineImpl

class Car(private var position: Int = 0, private var carEngine: CarEngine = RacingCarEngineImpl()) {

    fun movePosition() {
        if (carEngine.execute()) {
            move()
        }
    }

    private fun move() = position++

    fun getPosition() = position

    override fun toString(): String {
        return "-".repeat(position)
    }
}
