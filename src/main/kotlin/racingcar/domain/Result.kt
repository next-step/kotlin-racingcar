package racingcar.domain

data class Result(val carResults: List<CarResult>) {

    companion object {
        fun from(cars: List<Car>): Result {
            val carResults = cars.map(::CarResult)
            return Result(carResults)
        }
    }
}

data class CarResult(val name: String, val distance: Int) {
    constructor(car: Car) : this(car.name.value, car.distance)
}
