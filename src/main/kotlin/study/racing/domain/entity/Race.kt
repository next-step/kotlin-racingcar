package study.racing.domain.entity

class Race constructor(
    roundCount: Int,
    cars: List<RacingCar>,
) {
    var rounds: List<Round> = List(roundCount) { Round(cars) }
        private set

    fun start() {
        rounds.forEach(Round::race)
    }
}