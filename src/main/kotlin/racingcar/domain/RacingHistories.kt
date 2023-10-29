package racingcar.domain

class RacingHistories {
    private val histories: MutableList<List<RacingHistory>> = mutableListOf()

    fun addRacingHistories(histories: List<RacingHistory>) {
        this.histories.add(histories)
    }

    fun getRacingHistories() = histories.toList()
}

data class RacingHistory(
    private val move: Int
) {
    fun getMovingSymbol(symbol: String) = symbol.repeat(move)
}
