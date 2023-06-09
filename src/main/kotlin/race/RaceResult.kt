package race

data class RaceResult(
    val turns: List<TurnInfo>,
) {
    fun frontrunners(): Set<Car> {
        val positionOfFrontrunner = positionOfFrontrunner()
        return latestTurn().cars
            .filter {
                it.position == positionOfFrontrunner
            }.toSet()
    }

    private fun positionOfFrontrunner(): Int {
        return latestTurn().cars
            .maxOf {
                it.position
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
