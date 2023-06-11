package racingcar.model

class RacingCars(cars: Collection<RacingCar>) {

    val cars: Collection<RacingCar> = cars.toList()

    val nextMoved: RacingCars get() = RacingCars(cars.map { it.nextMoved })

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
}
