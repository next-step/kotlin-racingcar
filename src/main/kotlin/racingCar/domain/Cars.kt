package racingCar.domain

class Cars(carNames: List<CarName>, private val strategy: MoveStrategy) {

    val cars: Map<CarName, Car> = carNames.map { it to Car() }.toMap()

    fun moveByStrategy() {
        cars.forEach {
            it.value.moveByStrategy(strategy)
        }
    }

    fun findWinners(): List<CarName>? =
        this.cars.maxByOrNull { it.value.position.position }?.let { maxPosition ->
            return findUsernamesWithPosition(maxPosition.value.position)
        }

    private fun findUsernamesWithPosition(position: Position): List<CarName> =
        this.cars.filter { it.value.isSamePosition(position) }.map { it.key }
}
