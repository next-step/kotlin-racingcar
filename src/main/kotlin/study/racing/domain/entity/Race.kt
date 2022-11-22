package study.racing.domain.entity

import study.racing.PowerSource
import study.racing.domain.repository.RacingCarRepository

class Race constructor(
    roundCount: Int,
    carCount: Int,
    powerSource: PowerSource,
) {
    private val cars: List<RacingCar> = List(carCount) { RacingCar(RacingCarRepository(powerSource)) }
    val rounds: List<Round> = List(roundCount) { Round(cars) }

    fun start() {
        rounds.forEach(Round::race)
    }
}