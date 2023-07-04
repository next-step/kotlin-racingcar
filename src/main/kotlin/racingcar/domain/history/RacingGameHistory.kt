package racingcar.domain.history

class RacingGameHistory {
    private val histories: MutableList<RoundHistory> = mutableListOf()

    fun addHistory(roundHistory: RoundHistory) {
        histories.add(roundHistory)
    }

    fun getWinnerNames(): List<String> {
        return histories.last()
            .maxPositionCarInfos()
            .map { it.name }
    }

    fun getHistories() = histories.toList()
}
