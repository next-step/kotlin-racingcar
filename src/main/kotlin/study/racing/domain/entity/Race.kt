package study.racing.domain.entity

class Race(
    roundCount: Int,
    cars: List<RacingCar>,
) {
    val rounds: List<Round> = List(roundCount) { Round(cars) }

    fun start() {
        rounds.forEach(Round::race)
    }
}