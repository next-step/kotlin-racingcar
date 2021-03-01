package racingcar.domain

class RacingCarGame(carCount: Int, roundCount: Int) {

    private val rounds: List<Round>

    init {
        val cars = (1..carCount).map { Car(RandomMoveStrategy(RandomGenerator(0, 9), 4)) }
        rounds = (1..roundCount).map { Round(cars) }
    }

    fun start() {
        rounds.forEach { it.play() }
    }

    fun result(): Results {
        return Results(rounds.map { it.result() })
    }
}
