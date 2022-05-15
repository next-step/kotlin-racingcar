package racingcar.car

import racingcar.engine.Engine

class Car(engine: Engine) {

    fun forward() {}

    fun position(): Position {
        return Position(100)
    }
}
