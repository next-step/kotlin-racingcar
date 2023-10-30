package racing.model

import racing.model.generator.RandomGenerator
import racing.model.move.MoveThresholdStrategy

class RacingCar {

    private val strategy = MoveThresholdStrategy(RandomGenerator())

    fun racing(participates: ArrayDeque<String>, roundCount: Int): ArrayDeque<RacingHistory> {
        var current: RacingHistory = ready(participates)
        val racingHistories = ArrayDeque<RacingHistory>()
        for (i in 1..roundCount) {
            current = roundStart(current)
            racingHistories.add(current.copy())
        }
        return racingHistories
    }

    private fun ready(participates: ArrayDeque<String>): RacingHistory {
        return RacingHistory(
            ArrayDeque(
                participates.map {
                    Car(it, 0)
                }
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
