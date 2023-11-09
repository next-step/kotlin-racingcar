package racingcar.domain

class Game(
    carNames: List<String>,
    private val tryCount: Int,
) {
    private val cars: List<Car> = carNames.map { Car(name = it) }

    fun run(): List<GameResult> {
        val gameResult = mutableListOf<GameResult>()
        for (stage in (0 until tryCount)) {
            gameResult.add(runGameOneStage())
        }
        return gameResult
    }

    private fun runGameOneStage(): GameResult {
        cars.forEach { car ->
            car.moveOrStop()
        }
        return GameResult(cars.map { it.copy() })
    }
}
