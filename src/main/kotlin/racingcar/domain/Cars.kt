package racingcar.domain

class Cars(
    val cars: List<Car>,
    private val strategy: MoveStrategy
) {

    fun moveByStrategy(): Cars {
        val cars = cars.map {
            it.moveByStrategy(strategy)
        }
        return Cars(cars, strategy)
    }

    fun findWinners(): List<Car> =
        this.cars.maxOf { it }.let { winnerCar ->
            return findSamePositionOf(winnerCar)
        }

    private fun findSamePositionOf(winner: Car): List<Car> = this.cars
        .filter { it.isSamePosition(winner) }
        .map { it.copy() }

    companion object {
        fun ofNames(carNames: List<String>, strategy: MoveStrategy): Cars {
            require(carNames.isNotEmpty()) { "자동차이름은 한개 이상이여야만 합니다." }
            val cars = carNames.map { Car(name = CarName(it)) }
            return Cars(cars, strategy)
        }
    }
}
