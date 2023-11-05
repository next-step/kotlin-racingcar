package racingcar

class Game(
    carNumber: Int,
    private val tryCount: Int,
) {
    private val cars: Array<Car> = Array(carNumber) { Car() }

    fun run(): List<GameResult> {
        val gameResult = mutableListOf<GameResult>()
        for (stage in (0 until tryCount)) {
            gameResult.add(runGameOneStage())
        }
        return gameResult
    }

    private fun runGameOneStage(): GameResult {
        cars.forEach { car ->
            car.move()
        }
        return GameResult(cars.map { it.copy() })
    }
}
