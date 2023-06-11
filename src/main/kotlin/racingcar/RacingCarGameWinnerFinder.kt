package racingcar

object RacingCarGameWinnerFinder {

    fun findWinnerNames(gameRoundResults: List<RacingCarRoundResult>, lastRound: Long): List<String> {
        val lastRoundResults = getLastRoundResults(gameRoundResults, lastRound)

        val maxPositionCarResult = lastRoundResults.maxBy { it.position }

        return lastRoundResults.asSequence()
            .filter { it.position == maxPositionCarResult.position }
            .map { it.carName }
            .toList()
    }

    private fun getLastRoundResults(
        gameRoundResults: List<RacingCarRoundResult>,
        lastRound: Long
    ) = gameRoundResults.asSequence()
        .filter { it.round == lastRound }
        .map { it.carDriveResults }
        .flatten()
        .toList()
}
