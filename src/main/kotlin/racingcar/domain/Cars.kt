package racingcar.domain

class Cars(
    private val cars: List<Car>,
) {
    fun move() {
        cars.forEach { it.move() }
    }

    fun move(tryCount: Int) {
        repeat(tryCount) {
            move()
        }
    }

    fun getCars(): List<Car> {
        return cars
    }
}
