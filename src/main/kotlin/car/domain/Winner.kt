package car.domain

data class Winner(val carName: CarName) {
    override fun toString(): String {
        return carName.name
    }
}
