package racingcar.car

import racingcar.engine.CarEngine

class Car(private var position: Int = 0) {

    fun movePosition(carEngine: CarEngine) {
        if (carEngine.execute()) {
            position++
        }
    }

    fun getPosition() = position
}
