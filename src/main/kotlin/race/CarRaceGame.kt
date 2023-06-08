package race

class CarRaceGame {
    fun runCarRace(startInformation: RaceStartInformation): RaceResult {
        var raceResult = RaceResult.getInitialRaceResult(startInformation)

        for (i in 0 until startInformation.numberOfAttempts) {
            raceResult = runSingleRace(raceResult)
        }

        return raceResult
    }

    private fun runSingleRace(previousResult: RaceResult): RaceResult {
        return previousResult.latestCarPositions()
            .map {
                it.turn()
            }.let {
                previousResult.appendTurn(Turn(it))
            }
    }

    private fun CarPosition.turn(): CarPosition {
        if (canMove()) return goForward()
        return this
    }

    private fun canMove(): Boolean {
        return generateRandomSingleDigit() >= MOVE_THRESHOLD
    }

    private fun generateRandomSingleDigit(): Int = (0..9).random()

    companion object {
        private const val MOVE_THRESHOLD = 4
    }
}
