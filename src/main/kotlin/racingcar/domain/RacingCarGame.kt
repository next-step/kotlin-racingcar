package racingcar.domain

private const val MIN_RANDOM_VALUE = 0
private const val MAX_RANDOM_VALUE = 9
private const val THRESHOLD = 4

class RacingCarGame(positiveCount: PositiveCount, roundCount: PositiveCount) {

    private val rounds: List<Round>

    init {
        val zeroToNineRandomGenerator = RandomGenerator(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
        val fortyPercentMoveableStrategy = RandomMoveStrategy(zeroToNineRandomGenerator, THRESHOLD)
        val cars = (1..positiveCount.value).map { Car(fortyPercentMoveableStrategy) }
        rounds = (1..roundCount.value).map { Round(cars) }
    }

    fun start() {
        rounds.forEach { it.play() }
    }

    fun result(): Results {
        return Results(rounds.map { it.result() })
    }
}
