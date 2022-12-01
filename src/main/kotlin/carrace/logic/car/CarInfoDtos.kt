package carrace.logic.car

data class CarInfo(
    val carName: CarName,
    val carPosition: CarPosition
) {
    constructor(car: Car) : this(
        carName = car.carName,
        carPosition = car.carPosition
    )
}

data class CarInfos(
    val carInfos: List<CarInfo>
) {
    constructor(cars: Cars) : this(
        cars.cars.map(::CarInfo)
    )

    constructor(winners: Winners) : this(
        winners.cars.map(::CarInfo)
    )
}
