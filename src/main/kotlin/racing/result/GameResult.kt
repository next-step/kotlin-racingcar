package racing.result

class GameResult(
    val roundResults: List<RoundResult>
) {
    fun getWinners(): List<Winner> {
        val lastRoundResult = roundResults.maxBy { it.round } ?: return listOf()

        return lastRoundResult.getRoundWinners()
    }
}

fun List<RoundResult>.toGameResult(): GameResult {
    return GameResult(this)
}