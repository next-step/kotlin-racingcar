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
        this.location += engine.run()
    }
}
