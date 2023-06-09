package race

class CarRaceGame {
    fun runCarRace(startInformation: RaceStartInformation): RaceResult {
        var raceResult = RaceResult.getInitialRaceResult(startInformation)

        repeat(startInformation.numberOfAttempts) {
            raceResult = raceResult.proceedNextTurn()
        }

        return raceResult
    }

    private fun RaceResult.proceedNextTurn(): RaceResult {
        return appendTurn(latestTurn().proceedNextTurn())
    }

    private fun TurnInfo.proceedNextTurn(): TurnInfo {
        return Turn(carPositions.proceedNextTurn())
    }

    private fun List<CarPosition>.proceedNextTurn(): List<CarPosition> {
        return map { it.proceedNextTurn() }
    }

    private fun CarPosition.proceedNextTurn(): CarPosition {
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
