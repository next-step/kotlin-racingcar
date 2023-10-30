package racing.model

class RacingHistory(
    val roundHistories: ArrayDeque<RoundHistory>,
) {
    fun winners(): Set<Car> {
        val largestPosition = requireNotNull(
            roundHistories.last()
                .result.maxOfOrNull { it.position }
        )
        return roundHistories.last()
            .result
            .filter { it.position >= largestPosition }
            .toSet()
    }
}
