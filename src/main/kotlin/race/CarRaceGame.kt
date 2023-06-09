package race

class CarRaceGame(private val randomUtil: RandomUtil) {
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
        return randomUtil.generateRandomSingleDigit() >= MOVE_THRESHOLD
    }

    companion object {
        private const val MOVE_THRESHOLD = 4
    }
}
