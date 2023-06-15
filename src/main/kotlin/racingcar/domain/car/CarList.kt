package racingcar.domain.car

data class CarList(
    val cars: List<Car>
) {
    fun race(tryCount: Int) {
        cars.forEach { car -> car.race(tryCount) }
    }

    companion object {

        fun of(carCount: Int) = CarList(
            cars = (0 until carCount).map { Car() }
        )
    }
}
