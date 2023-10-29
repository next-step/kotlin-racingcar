package racing.model

import racing.model.generator.RandomGenerator
import racing.model.move.MoveThresholdStrategy

class RacingCar {

    private val strategy = MoveThresholdStrategy(RandomGenerator())

    fun racing(participate: Int, roundCount: Int): ArrayDeque<RacingHistory> {
        var current: RacingHistory = ready(participate)
        val racingHistories = ArrayDeque<RacingHistory>()
        for (i in 1..roundCount) {
            current = roundStart(current)
            racingHistories.add(current.copy())
        }
        return racingHistories
    }

    private fun ready(participate: Int): RacingHistory {
        return RacingHistory(
            ArrayDeque(
                (1..participate)
                    .map { Car(it, 0) }
            )
        )
    }

    private fun roundStart(preRacingHistory: RacingHistory): RacingHistory {
        return RacingHistory(
            ArrayDeque(
                preRacingHistory.result
                    .map { it.move(strategy).copy() }
            )
        )
    }
}
