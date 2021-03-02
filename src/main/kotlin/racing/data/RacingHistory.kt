package racing.data

class RacingHistory {
    val roundResults = mutableListOf<RoundResult>()

    fun recordRoundResult(roundResult: RoundResult) {
        roundResults.add(roundResult)
    }
}
