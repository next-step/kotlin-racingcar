package carracing.controller

import carracing.domain.Car
import carracing.domain.RacingRound

class RacingGame(
    private val carNames: List<String>,
    private val racingCount: Int,
) {
    fun start(): List<RacingRound> {
        val cars = carNames.map { Car(it) }
        return mutableListOf<RacingRound>().apply {
            repeat(racingCount) { round ->
                cars.map { it.move() }
                this.add(RacingRound.of(round, cars))
            }
        }
    }
}
