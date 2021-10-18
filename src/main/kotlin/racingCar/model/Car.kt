package racingCar.model

class Car(private val name: String) {

    var mileage: Int = 0
        private set

    fun move(move: Int) = when (conditionOfMove(move)) {
        true -> forward()
        false -> stop()
    }

    private fun forward() {
        mileage = ForwardStrategy().move(mileage)
    }

    private fun stop() {
        mileage = StopStrategy().move(mileage)
    }
}
