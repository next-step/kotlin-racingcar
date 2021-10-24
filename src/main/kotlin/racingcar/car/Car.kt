package racingcar.car

import racingcar.engine.CarEngine

class Car(private var name: String = "", private var position: Int = 0) {

    fun movePosition(carEngine: CarEngine) {
        if (carEngine.execute()) {
            position++
        }
    }

    fun getName() = name

    fun getPosition() = position
}
