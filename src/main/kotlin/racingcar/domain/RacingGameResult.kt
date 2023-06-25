package racingcar.domain

data class RacingGameResult(val roundHistories: List<RoundHistory>) {
    fun getWinnerNames(): CarNames {
        val finalRoundHistory = roundHistories.last()

        return finalRoundHistory.getWinnerNames()
    }
}
