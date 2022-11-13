package racingCar.domain

class Cars(usernames: List<Username>, private val strategy: MoveStrategy) {

    val cars: Map<Username, Car> = usernames.map { it to Car() }.toMap()

    fun moveByStrategy() {
        cars.forEach {
            it.value.moveByStrategy(strategy)
        }
    }

    fun findWinners(): List<Username>? =
        this.cars.maxByOrNull { it.value.position.position }?.let { maxPosition ->
            return findUsernamesWithPosition(maxPosition.value.position)
        }

    private fun findUsernamesWithPosition(position: Position): List<Username> =
        this.cars.filter { it.value.position == position }.map { it.key }
}
