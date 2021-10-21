package racingCar.model

data class Car(private val carName: CarName, private val movement: Movement) {
    constructor(name: String, movement: Movement) : this(CarName(name), movement)

    private var mileage: Int = 0

    fun move() {
        mileage += movement.amount()
    }

    fun info() = Pair(carName.name, mileage)
}
