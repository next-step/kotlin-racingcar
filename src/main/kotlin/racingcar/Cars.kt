package racingcar

class Cars(
    private val cars: List<Car>
) {
    fun getCars() = cars

    fun race() {
        cars.map { it.move() }
    }
}
