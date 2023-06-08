package race

data class RaceResult(
    val turns: List<Turn>,
) {
    fun latestTurn() = turns.last()

    fun appendTurn(turn: Turn) = copy(turns = turns.plus(turn))

    companion object {
        fun getInitialRaceResult(startInformation: RaceStartInformation): RaceResult {
            return (0 until startInformation.numberOfCars).map {
                CarPosition(1)
            }.let {
                RaceResult(listOf(Turn(it)))
            }
        }
    }
}
