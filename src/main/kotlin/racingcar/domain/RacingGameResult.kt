package racingcar.domain

data class RacingGameResult(val roundHistories: List<RoundHistory>) {
    fun getWinnerNames(): List<CarName> {
        val finalRoundHistory = roundHistories.last()

        return finalRoundHistory.getWinnerNames()
    }
}
