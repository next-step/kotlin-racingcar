package racing.model

import racing.model.generator.RandomGenerator
import racing.model.move.MoveRandomStrategy

class RacingCar {
    private val strategy = MoveRandomStrategy(RandomGenerator())

    fun race(participate: Int, roundCount: Int): ArrayDeque<MatchResult> {
        var current: MatchResult = ready(participate)
        val matchResults = ArrayDeque<MatchResult>()
        for (i in 1..roundCount) {
            current = roundGo(current)
            matchResults.add(current.copy())
        }
        return matchResults
    }

    private fun ready(participate: Int): MatchResult {
        return MatchResult(
            ArrayDeque(
                (1..participate)
                    .map { Car(it, 0) }
            )
        )
    }

    private fun roundGo(preMatchResult: MatchResult): MatchResult {
        return MatchResult(
            ArrayDeque(
                preMatchResult.result
                    .map { it.start(strategy).copy() }
            )
        )
    }
}
