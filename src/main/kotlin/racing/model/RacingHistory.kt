package racing.model

class RacingHistory(
    val roundHistories: ArrayDeque<RoundHistory>,
) {
    fun winner(): Set<Car> {
        val finalLap = roundHistories.last()
        val largestDistance = finalLap.result
            .map { it -> it.position }
            .max()
        return finalLap.result
            .filter { it -> it.position >= largestDistance }
            .toSet()
    }
}
