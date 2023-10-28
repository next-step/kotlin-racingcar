package racing.model

import racing.model.generator.RandomGenerator
import racing.model.move.MoveRandomStrategy

class Racing {
    private val strategy = MoveRandomStrategy(RandomGenerator())

    fun race(participate: Int, repeat: Int): ArrayDeque<MatchResult> {
        var current: MatchResult = ready(participate)
        val matchResults = ArrayDeque<MatchResult>()
        for (i in 1..repeat) {
            current = roundGo(current.copy())
            matchResults.add(current)
        }
        return matchResults
    }

    private fun ready(participate: Int): MatchResult {
        val cars = (1..participate)
            .map { Car(it, 0) }
            .toList()
        return MatchResult(ArrayDeque(cars))
    }

    private fun roundGo(preMatchResult: MatchResult): MatchResult {
        val cars = preMatchResult.result
            .stream()
            .map { it.start(strategy).copy() }
            .toList()
        return MatchResult(ArrayDeque(cars))
    }
}
