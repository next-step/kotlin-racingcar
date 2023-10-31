package racingcar.domain

class RacingResult {
    val allRounds: MutableList<List<RacingHistory>> = mutableListOf()

    data class RacingHistory(
        val name: String,
        val move: Int
    )

    fun addRacingHistories(histories: List<RacingHistory>) {
        this.allRounds.add(histories)
    }

    fun getRacingWinners(): List<RacingHistory> = allRounds.last()
        .let { histories ->
            val max = histories.maxBy(RacingHistory::move)
            histories.filter { it.move == max.move }
        }
}
