package study.racingcar.race

import study.racingcar.car.CarState

data class RaceSummary(
    val raceResults: List<RaceResult>
) {
    fun determineWinners(): List<String> {
        val finalCarStates = getFinalCarStates()
        val maxPosition = getMaxPosition(finalCarStates)
        return finalCarStates.filter { it.position == maxPosition }.map { it.name }
    }

    private fun getFinalCarStates(): List<CarState> {
        return raceResults.last().attemptResults
    }

    private fun getMaxPosition(finalCarStates: List<CarState>): Int {
        return finalCarStates.maxByOrNull { it.position }?.position ?: 0
    }
}
