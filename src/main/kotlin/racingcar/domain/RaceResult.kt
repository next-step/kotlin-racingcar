package racingcar.domain

data class RaceResult(
    val raceHistories: List<RaceHistory>,
) {
    fun findRacingChampions(): List<String> {
        val finalRaceHistory = raceHistories.lastOrNull() ?: throw IllegalArgumentException("레이스 기록 목록이 비었습니다.")

        return finalRaceHistory.findMaxPositionCarNames()
    }
}
