package racingcar.domain.car

data class CarList(
    val cars: List<Car>
) {
    fun race(tryCount: Int) {
        cars.forEach { car -> car.race(tryCount) }
    }

    fun getWinner(): CarList {
        val maxPosition = cars.maxOf { it.position }
        return CarList(cars.filter { it.position == maxPosition })
    }

    override fun toString(): String {
        return cars.joinToString(", ") { it.name }
    }

    companion object {

        fun of(carNames: String) =
            CarList(
                cars = CarNameParser.parse(carNames).map { carName -> Car(carName) }
            )
    }
}
