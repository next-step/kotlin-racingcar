package racingcar.domain

class RacingCarGame(carNames: List<CarName>, roundCount: PositiveCount) {

    private val cars: List<Car>
    private val rounds: List<Round>

    init {
        val zeroToNineRandomGenerator = RandomGenerator(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
        val fortyPercentMoveableStrategy = RandomMoveStrategy(zeroToNineRandomGenerator, THRESHOLD)
        cars = carNames.map { Car(it.value, fortyPercentMoveableStrategy) }
        rounds = (1..roundCount.value).map { Round() }
    }

    fun start() {
        rounds.forEach { play(it) }
    }

    private fun play(round: Round) {
        cars.forEach { it.moveIfMoveable() }
        val result = Result(cars.map { CarResult(it.displayName(), it.currentDistance()) })
        round.recordResult(result)
    }

    fun result(): Results {
        val results = rounds.map { it.result() }
        val winner = findWinner()

        return Results(results, winner)
    }

    private fun findWinner(): List<Winner> {
        val maxValue = cars.map { it.currentDistance() }.max() ?: throw IllegalArgumentException("distance가 존재하지 않습니다")
        return cars.filter { it.currentDistance() == maxValue }.map { it.displayName() }.map { Winner(it) }
    }

    companion object {
        private const val MIN_RANDOM_VALUE = 0
        private const val MAX_RANDOM_VALUE = 9
        private const val THRESHOLD = 4
    }
}
