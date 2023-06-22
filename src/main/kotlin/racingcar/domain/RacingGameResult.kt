package racingcar.domain

data class RacingGameResult(val roundHistories: List<RoundHistory>) {
    fun getWinnerNames(): List<String> {
        val finalRoundHistory = roundHistories.last()

        return finalRoundHistory.getWinnerNames()
    }
}
