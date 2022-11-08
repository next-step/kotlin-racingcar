package study.racing.entity

class Race constructor(
    roundCount: Int,
    carCount: Int,
) {
    private var cars: List<RacingCar> = List(carCount) { RacingCar() }
    var rounds: List<Round> = List(roundCount) { Round(cars) }
        private set

    fun start() {
        rounds.forEach(Round::race)
    }
}