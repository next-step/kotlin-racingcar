package racingcar.domain

class RacingCarGame(carCount: CarCount, roundCount: RoundCount) {

    private val rounds: List<Round>

    init {
        val zeroToNineRandomGenerator = RandomGenerator(0, 9)
        val fortyPercentMoveableStrategy = RandomMoveStrategy(zeroToNineRandomGenerator, 4)
        val cars = (1..carCount.value).map { Car(fortyPercentMoveableStrategy) }
        rounds = (1..roundCount.value).map { Round(cars) }
    }

    fun start() {
        rounds.forEach { it.play() }
    }

    fun result(): Results {
        return Results(rounds.map { it.result() })
    }
}
