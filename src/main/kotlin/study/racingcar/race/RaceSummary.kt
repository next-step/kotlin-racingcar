package study.racingcar.race

data class RaceSummary(
    val raceResults: List<RaceResult>
) {

    fun determineWinners(): List<String> {
        val finalCarStates = getFinalCarStates()
        val maxPosition = getMaxPosition(finalCarStates)
        return finalCarStates.filter { it.position.length == maxPosition }.map { it.name }
    }

    private fun getFinalCarStates(): List<CarState> {
        return raceResults.last().attemptResults
    }

    private fun getMaxPosition(finalCarStates: List<CarState>): Int {
        return finalCarStates.maxByOrNull { it.position.length }?.position?.length ?: 0
    }
}
