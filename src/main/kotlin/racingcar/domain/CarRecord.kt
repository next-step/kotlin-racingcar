package racingcar.domain

data class CarRecord(
    val carName: CarName,
    val location: Location
) {
    companion object {
        fun of(car: Car): CarRecord {
            return CarRecord(car.carName, car.location)
        }
    }
}
