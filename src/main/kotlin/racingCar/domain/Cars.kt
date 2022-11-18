package racingCar.domain

class Cars(carNames: List<String>, private val strategy: MoveStrategy) {

    val cars: List<Car>

    init {
        require(carNames.isNotEmpty()) { "자동차이름은 한개 이상이여야만 합니다." }
        cars = carNames.map { Car(name = CarName(it)) }
    }

    fun moveByStrategy() {
        cars.forEach {
            it.moveByStrategy(strategy)
        }
    }

    fun findWinners(): List<Car> =
        this.cars.maxByOrNull { it }!!.let { winnerCar ->
            return findSamePositionOf(winnerCar)
        }

    private fun findSamePositionOf(winner: Car): List<Car> = this.cars.filter { it.isSamePosition(winner) }
}
