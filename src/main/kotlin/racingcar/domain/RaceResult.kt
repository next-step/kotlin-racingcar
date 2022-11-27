package racingcar.domain

data class RaceResult(val roundHistories: List<RoundHistory>) {
    fun getWinners(): List<String>? {
        val lastRoundCarInfos = getLastRoundCarInfos().groupBy { (_, position) -> position }.toSortedMap()
        val winnersPosition = lastRoundCarInfos.lastKey()

        return lastRoundCarInfos[winnersPosition]?.map { (name, _) -> name }
    }

    private fun getLastRoundCarInfos(): List<Pair<String, Int>> {
        return getLastRoundHistory().carInfos
    }
    private fun getLastRoundHistory(): RoundHistory {
        return roundHistories.last()
    }
}
