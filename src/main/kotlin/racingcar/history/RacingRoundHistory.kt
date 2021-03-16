package racingcar.history

import racingcar.domain.Car

class RacingRoundHistory(
    private val round: Int,
    val racingActionHistories: List<RacingActionHistory>
) {
    companion object {
        fun of(round: Int, cars: List<Car>): RacingRoundHistory {
            val actions = cars
                .map { RacingActionHistory(it.position) }

            return RacingRoundHistory(round, actions)
        }
    }
}
