package racingcar.car

import racingcar.engine.CarEngine

class Car(private var name: String = "", private var position: Int = 0, private var carEngine: CarEngine) {

    fun movePosition() {
        if (carEngine.execute()) {
            position++
        }
    }

    fun getName() = name

    fun getPosition() = position
}
