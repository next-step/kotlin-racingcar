package racingcar.model

class RacingCars(cars: Collection<RacingCar> = emptyList()) {

    val cars: Collection<RacingCar> = cars.toList()

    val names: Collection<CarName> get() = cars.map { it.name }

    val nextMoved: RacingCars get() = RacingCars(cars.map { it.nextMoved })

    val farthestCars: RacingCars
        get() {
            return cars.maxByOrNull { it.wentDistance }?.let { farthestCar ->
                RacingCars(cars.filter { it.wentDistance == farthestCar.wentDistance })
            } ?: RacingCars()
        }

    fun forEach(action: (RacingCar) -> Unit) = cars.forEach(action)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RacingCars

        return cars == other.cars
    }

    override fun hashCode(): Int {
        return cars.hashCode()
    }

    override fun toString(): String {
        return "RacingCars(cars=$cars)"
    }
}
