package racing.model

class RacingHistory(
    val roundHistories: ArrayDeque<RoundHistory>,
) {

    constructor() : this(ArrayDeque())

    fun winners(): Set<Car> {
        val largestPosition = requireNotNull(
            roundHistories.last()
                .result
                .maxOfOrNull { it.position }
        )
        return roundHistories.last()
            .result
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
