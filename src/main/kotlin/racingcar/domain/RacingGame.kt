package racingcar.domain

class RacingGame(
    carNames: List<String>,
    private val tryCount: Int,
) {
    private val cars: List<Car> = carNames.map { Car(name = it) }

    fun run(): List<RacingGameResult> {
        val racingGameResult = mutableListOf<RacingGameResult>()
        for (stage in (0 until tryCount)) {
            racingGameResult.add(runGameOneStage())
        }
        return racingGameResult
    }

    private fun runGameOneStage(): RacingGameResult {
        cars.forEach { car ->
            car.moveOrStop()
        }
        return RacingGameResult(cars.map { it.copy() })
    }
}
