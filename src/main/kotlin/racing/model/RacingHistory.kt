package racing.model

class RacingHistory(
    val roundHistories: ArrayDeque<RoundHistory>,
) {

    constructor() : this(ArrayDeque())

    fun winners(): Set<Car> {
        val largestPosition = requireNotNull(
            roundHistories.last()
                .results
                .maxOfOrNull { it.position }
        )
        return roundHistories.last()
            .results
            .filter { it.position >= largestPosition }
            .toSet()
    }

    fun appendRound(roundHistory: RoundHistory) {
        this.roundHistories.add(roundHistory)
    }

    fun lastRound(): RoundHistory {
        return roundHistories.last()
    }
}
