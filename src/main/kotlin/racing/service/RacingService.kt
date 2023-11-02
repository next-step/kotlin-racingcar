package racing.service

import racing.model.Car
import racing.model.RacingHistory
import racing.model.RoundHistory
import racing.model.generator.RandomGenerator
import racing.model.move.MoveThresholdStrategy

class RacingService {

    private val strategy = MoveThresholdStrategy(RandomGenerator())

    fun racing(participates: ArrayDeque<String>, roundCount: Int): RacingHistory {
        val racingHistory = RacingHistory()
        racingHistory.appendRound(ready(participates))
        (1..roundCount).forEach { _ ->
            racingHistory.appendRound(nextRound(racingHistory.lastRound()))
        }
        return racingHistory
    }

    private fun ready(participates: ArrayDeque<String>): RoundHistory {
        return RoundHistory(
            participates.map { Car(it, 0) }
        )
    }

    private fun nextRound(preRoundHistory: RoundHistory): RoundHistory {
        return RoundHistory(
            preRoundHistory
                .results.map { it.move(strategy).copy() }
        )
    }
}
