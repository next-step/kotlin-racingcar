package racingcar.domain

class RoundHistory(val positionHistories: List<PositionHistory>) {
    fun getWinnerNames(): CarNames {
        val winnerPosition = this.positionHistories.maxBy { it.position.value }.position

        return CarNames(positionHistories.filter { it.position == winnerPosition }.map { it.name })
    }
}
