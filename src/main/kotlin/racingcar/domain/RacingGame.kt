package racingcar.domain

class RacingGame(
    carNames: List<String>,
    private val tryCount: Int,
) {
    private val cars: List<Car> = carNames.map { Car(name = it) }

    fun run(): List<RacingGameResult> {
        return List(tryCount) { runGameOneStage() }
    }

    private fun runGameOneStage(): RacingGameResult {
        cars.forEach { car ->
            car.moveOrStop(RandomPowerEngine())
        }
        return RacingGameResult(cars.map { it.copy() })
    }
}
