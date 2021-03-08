package racingcar.domain.car

import racingcar.domain.car.engine.Engine

class Car(
    val name: CarName,
    private val engine: Engine
) {
    var location: CarLocation = CarLocation.ZERO

    fun race(): CarLocation {
        goForward()
        return location
    }

    private fun goForward() {
        location = location.moveBy(engine.run())
    }
}
