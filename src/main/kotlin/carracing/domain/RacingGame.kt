package carracing.domain

class RacingGame(
    private val carNames: List<String>,
    private val racingCount: Int,
    private val racingGameRule: RacingGameRule,
) {
    fun start(): List<RacingRound> {
        val cars = carNames.map { Car(it) }
        return mutableListOf<RacingRound>().apply {
            repeat(racingCount) { round ->
                racingGameRule.execute(cars)
                this.add(RacingRound.of(round, cars))
            }
        }
    }
}
