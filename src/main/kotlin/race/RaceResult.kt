package race

data class RaceResult(
    val turns: List<TurnInfo>,
) {
    fun frontrunners(): Set<Car> {
        val frontrunner = frontrunner()
        return latestTurn().cars
            .filter {
                frontrunner.isDraw(it)
            }.toSet()
    }

    private fun frontrunner(): Car {
        return latestTurn().cars
            .reduce { frontrunner, car ->
                Car.winner(frontrunner, car)
            }
    }

    fun latestTurn() = turns.last()

    fun appendTurn(turn: TurnInfo) = copy(turns = turns.plus(turn))

    companion object {
        fun getInitialRaceResult(startInformation: RaceStartInformation): RaceResult {
            return RaceResult(listOf(InitialTurn(startInformation)))
        }
    }
}
