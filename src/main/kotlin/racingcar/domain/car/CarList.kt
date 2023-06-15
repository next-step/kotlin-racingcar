package racingcar.domain.car

data class CarList(
    val cars: List<Car>
) {
    fun race(tryCount: Int) {
        cars.forEach { car -> car.race(tryCount) }
    }

    companion object {

        fun of(carNames: String) =
            CarList(
                cars = CarNameParser.parse(carNames).map { carName -> Car(carName) }
            )
    }
}
