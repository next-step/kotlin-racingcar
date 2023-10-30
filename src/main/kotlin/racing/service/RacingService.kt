package racing.service

import racing.model.Car
import racing.model.RacingHistory
import racing.model.RoundHistory
import racing.model.generator.RandomGenerator
import racing.model.move.MoveThresholdStrategy

class RacingService {

    private val strategy = MoveThresholdStrategy(RandomGenerator())

    fun racing(participates: ArrayDeque<String>, roundCount: Int): RacingHistory {
        var current: RoundHistory = ready(participates)
        val roundHistories = ArrayDeque<RoundHistory>()
        for (i in 1..roundCount) {
            current = roundStart(current)
            roundHistories.add(current.copy())
        }
        return RacingHistory(roundHistories)
    }

    private fun ready(participates: ArrayDeque<String>): RoundHistory {
        return RoundHistory(
            ArrayDeque(
                participates.map {
                    Car(it, 0)
                }
            )
        )
    }

    private fun roundStart(preRoundHistory: RoundHistory): RoundHistory {
        return RoundHistory(
            ArrayDeque(
                preRoundHistory.result
                    .map { it.move(strategy).copy() }
            )
        )
    }
}
