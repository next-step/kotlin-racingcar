package racingcar

class Car(
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
