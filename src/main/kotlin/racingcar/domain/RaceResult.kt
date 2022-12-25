package racingcar.domain

data class RaceResult(val roundHistories: List<RoundHistory>) {
    init {
        require(roundHistories.isNotEmpty()) { "자동차 경주 히스토리가 남아있지 않습니다." }
    }

    fun getFinalRoundWinners() = roundHistories.last().getWinners()
}
