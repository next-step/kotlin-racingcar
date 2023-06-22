package racingcar

data class RacingGameResult(val positionHistories: List<PositionHistory>) {
    fun getWinnerNames(): List<String> {
        val finalHistory = positionHistories.last()
        val winnerPosition = finalHistory.positions.maxBy { it.position }.position
        val winnerNames = finalHistory.positions.filter { it.position == winnerPosition }.map { it.name }

        return winnerNames
    }
}
