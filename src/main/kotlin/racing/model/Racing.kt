package racing.model

import racing.model.generator.RandomGenerator
import racing.model.move.MoveRandomStrategy
import java.util.stream.IntStream

class Racing {
    private val strategy = MoveRandomStrategy(RandomGenerator())

    fun race(participate: Int, repeat: Int): List<MatchResult> {
        var current: MatchResult = ready(participate)
        val list: MutableList<MatchResult> = mutableListOf()
        for (i in 1..repeat) {
            current = roundGo(current.copy())
            list.add(current)
        }
        return list
    }

    private fun ready(participate: Int): MatchResult {
        return MatchResult(
            IntStream.rangeClosed(1, participate)
                .boxed()
                .map { Car(it, 0) }
                .toList()
        )
    }

    private fun roundGo(preMatchResult: MatchResult): MatchResult {
        return MatchResult(
            preMatchResult.result
                .stream()
                .map { it.start(strategy).copy() }
                .toList()
        )
    }
}
