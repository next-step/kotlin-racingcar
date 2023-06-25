package racingcar.domain

class RoundHistory(val positionHistories: List<PositionHistory>) {
    init {
        require(positionHistories.all { it.position >= Car.DEFAULT_POSITION }) { "Car의 포지션은 ${Car.DEFAULT_POSITION} 이상이어야 합니다" }
    }

    fun getWinnerNames(): CarNames {
        val winnerPosition = this.positionHistories.maxBy { it.position }.position

        return CarNames(positionHistories.filter { it.position == winnerPosition }.map { it.name })
    }
}
