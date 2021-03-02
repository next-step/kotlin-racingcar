package racingcar.domain

private const val MIN_RANDOM_VALUE = 0
private const val MAX_RANDOM_VALUE = 9
private const val THRESHOLD = 4

class RacingCarGame(positiveCount: PositiveCount, roundCount: PositiveCount) {

    private val cars: List<Car>
    private val rounds: List<Round>

    init {
        val zeroToNineRandomGenerator = RandomGenerator(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
        val fortyPercentMoveableStrategy = RandomMoveStrategy(zeroToNineRandomGenerator, THRESHOLD)
        cars = (1..positiveCount.value).map { Car(fortyPercentMoveableStrategy) }
        rounds = (1..roundCount.value).map { Round() }
    }

    fun start() {
        rounds.forEach { play(it) }
    }

    private fun play(round: Round) {
        cars.forEach { it.moveIfMoveable() }
        val result = Result(cars.map { it.currentDistance() })
        round.recordResult(result)
    }

    fun result(): Results {
        return Results(rounds.map { it.result() })
    }
}
