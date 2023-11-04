package carracing

import carracing.dto.Car
import carracing.dto.RacingRound

class RacingGame(
    private val carCount: Int,
    private val racingCount: Int,
    private val racingGameRule: RacingGameRule,
) {
    fun start(): List<RacingRound> {
        val cars = List(carCount) { Car() }
        return mutableListOf<RacingRound>().apply {
            repeat(racingCount) { round ->
                racingGameRule.execute(cars)
                this.add(RacingRound.of(round, cars))
            }
        }
    }
}
