package race.domain

class CarRaceGame(private val randomUtil: DigitGenerator) {
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
        return Turn(cars.proceedNextTurn())
    }

    private fun List<Car>.proceedNextTurn(): List<Car> {
        return map { it.proceedNextTurn() }
    }

    private fun Car.proceedNextTurn(): Car {
        if (canMove()) return goForward()
        return this
    }

    private fun canMove(): Boolean {
        return randomUtil() >= MOVE_THRESHOLD
    }

    companion object {
        private const val MOVE_THRESHOLD = 4
    }
}
