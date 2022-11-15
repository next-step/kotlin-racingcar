package study.racing.entity

import study.racing.PowerSource

class Race constructor(
    roundCount: Int,
    carCount: Int,
    powerSource: PowerSource,
) {
    private val cars: List<RacingCar> = List(carCount) { RacingCar(powerSource) }
    val rounds: List<Round> = List(roundCount) { Round(cars) }

    fun start() {
        rounds.forEach(Round::race)
    }
}