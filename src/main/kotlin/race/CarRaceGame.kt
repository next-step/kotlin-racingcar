package race

class CarRaceGame {
    fun runCarRace(raceStartInformation: RaceStartInformation): RaceResult {
        val initialRaceResult = RaceResult.getInitialRaceResult(raceStartInformation)

        return (0 until raceStartInformation.numberOfAttempts).fold(initialRaceResult) { previousResult, _ ->
            runSingleRace(previousResult)
        }
    }

    private fun runSingleRace(previousResult: RaceResult): RaceResult {
        return previousResult.latestTurn()
            .carPositions
            .map {
                if (Math.random() * 10 > 4) {
                    it.goForward()
                } else {
                    it
                }
            }.let {
                previousResult.appendTurn(Turn(it))
            }
    }
}
