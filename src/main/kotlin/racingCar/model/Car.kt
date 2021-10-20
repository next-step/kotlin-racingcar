package racingCar.model

data class Car(private val carName: CarName) {
    constructor(name: String) : this(CarName(name))

    private var mileage: Int = 0

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

    fun info() = Pair(carName.name, mileage)
}
