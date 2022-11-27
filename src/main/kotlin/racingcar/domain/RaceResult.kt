package racingcar.domain

import racingcar.exception.CannotFindWinnerException

data class RaceResult(val roundHistories: List<RoundHistory>) {
    fun getWinners(): List<String> {
        val winners = getLastRoundCarInfos()
            .groupBy { (_, position) -> position }
            .toSortedMap().values
            .last()

        return winners.map { (name, _) -> name }
    }

    private fun getLastRoundCarInfos(): List<Pair<String, Int>> {
        val lastRoundCarInfos = getLastRoundHistory().carInfos
        if (lastRoundCarInfos.isEmpty()) throw CannotFindWinnerException()

        return lastRoundCarInfos
    }
    private fun getLastRoundHistory(): RoundHistory {
        return roundHistories.last()
    }
}
