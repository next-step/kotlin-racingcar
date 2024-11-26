package racingcar.domain

class Winners(cars: Cars) {
    private val winners: List<Car>

    init {
        val highestPosition: Position =
            cars.positions().maxByOrNull { it.position } ?: Position.init()
        winners =
            cars.cars
                .filter { it.position == highestPosition }
                .map { it }
    }

    fun getWinnerNames(): List<String> {
        return winners.map { it.username }
    }
}
