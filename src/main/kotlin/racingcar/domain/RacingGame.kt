package racingcar.domain

class RacingGame(
    private val cars: List<Car>,
    private val tryCount: Int,
) {
    fun run(engine: Engine): List<RacingGameResult> {
        return List(tryCount) { runGameOneStage(engine) }
    }

    private fun runGameOneStage(engine: Engine): RacingGameResult {
        return RacingGameResult(cars.map { it.moveOrStop(engine) })
    }
}
