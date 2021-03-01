package racing.result

class RoundResult(
    val round: Int,
    val racingHistories: List<RacingHistory>
) {

    fun getRoundWinners(): List<Winner> {
        val winnerHistory = findWinnerHistory() ?: return listOf()

        return racingHistories.filter { it.position == winnerHistory.position }
            .map {
                Winner(
                    round = round,
                    name = it.name,
                    position = it.position
                )
            }
    }

    private fun findWinnerHistory(): RacingHistory? {
        return racingHistories.sortedByDescending { it.position }
            .maxBy { it.position }
    }
}

fun List<RacingHistory>.toRoundResult(round: Int): RoundResult {
    return RoundResult(round, this)
}