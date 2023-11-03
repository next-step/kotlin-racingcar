package racingcar

class Cars(
    private val cars: List<Car>,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
) {
    fun moveCars() {
        cars.forEach { it.move(moveStrategy.move()) }
    }

    fun getCars(): List<Car> {
        return cars
    }

    fun getWinners(): List<Car> {
        val maxMoveCount = cars.maxByOrNull { it.moveCount }?.moveCount ?: 0
        return cars.filter { it.moveCount == maxMoveCount }
    }

    companion object {
        const val RANDOM_RANGE = 10
    }
}
