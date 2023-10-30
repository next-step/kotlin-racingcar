package racingcar.domain

class RacingHistories {
    private val histories: MutableList<List<RacingHistory>> = mutableListOf()

    data class RacingHistory(
        val move: Int
    )

    fun addRacingHistories(histories: List<RacingHistory>) {
        this.histories.add(histories)
    }

    fun getRacingHistories() = histories.toList()
}
