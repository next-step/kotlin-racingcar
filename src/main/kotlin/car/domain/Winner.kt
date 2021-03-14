package car.domain

data class Winner(val carName: CarName) {

    constructor(carName: String) : this(CarName(carName))

    override fun toString(): String {
        return carName.name
    }
}
