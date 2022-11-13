package study.racing.entity

import study.racing.PowerSource

class Race constructor(
    roundCount: Int,
    carCount: Int,
    powerSource: PowerSource,
) {
    private var cars: List<RacingCar> = List(carCount) { RacingCar(powerSource) }
    var rounds: List<Round> = List(roundCount) { Round(cars) }
        private set

    fun start() {
        rounds.forEach(Round::race)
    }
}