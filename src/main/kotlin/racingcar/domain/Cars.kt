package racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    fun getCars() = cars

    fun race() = cars.map { it.moveOrNot() }
}
