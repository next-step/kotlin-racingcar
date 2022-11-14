package study.racingcar.racing

data class RacingResult(val rounds: List<List<Record>>) {
    fun getWinners(): List<Record> {
        val lastResult = rounds.last()
        val maxLocation = getMaxLocation(lastResult)

        return lastResult.filter { result -> result.location == maxLocation }
    }

    private fun getMaxLocation(lastResult: List<Record>): Int {
        return lastResult.map { result ->
            result.location
        }.maxOrNull() ?: 1
    }
}
