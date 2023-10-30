package racing.model

import racing.model.generator.RandomGenerator
import racing.model.move.MoveThresholdStrategy

class RacingCar {

    private val strategy = MoveThresholdStrategy(RandomGenerator())

    fun racing(participates: ArrayDeque<String>, roundCount: Int): ArrayDeque<RoundHistory> {
        var current: RoundHistory = ready(participates)
        val racingHistories = ArrayDeque<RoundHistory>()
        for (i in 1..roundCount) {
            current = roundStart(current)
            racingHistories.add(current.copy())
        }
        return racingHistories
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
