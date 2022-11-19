package racingcar.domain

data class RaceResult(val roundHistories: List<RoundHistory>) {
    fun groupByRound(): Map<Int, List<RoundHistory>> {
        return roundHistories.groupBy { roundHistory -> roundHistory.round }
    }
}
