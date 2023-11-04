package racingcar.domain

class RacingResult(
    val allRounds: List<List<RacingHistory>>
) {

    data class RacingHistory(
        val name: String,
        val move: Int
    )

    fun getRacingWinners(): List<RacingWinner> {
        val winners = allRounds.last().let { histories ->
            val max = histories.maxBy(RacingHistory::move)
            histories.filter { it.move == max.move }
        }
        return winners.map { RacingWinner(it.name) }
    }
}
