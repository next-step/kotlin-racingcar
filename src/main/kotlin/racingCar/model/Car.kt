package racingCar.model

data class Car(private val carName: CarName) {
    constructor(name: String) : this(CarName(name))

    private var mileage: Int = 0

    fun move(move: MoveAmount) {
        mileage += move.amount()
    }

    fun info() = Pair(carName.name, mileage)
}
