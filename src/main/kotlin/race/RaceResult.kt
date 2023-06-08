package race

data class RaceResult(
    val turns: List<Turn>,
) {
    fun latestCarPositions() = turns.last()
        .carPositions

    fun appendTurn(turn: Turn) = copy(turns = turns.plus(turn))

    companion object {
        fun getInitialRaceResult(startInformation: RaceStartInformation): RaceResult {
            return RaceResult(listOf(Turn.getInitialTurn(startInformation)))
        }
    }
}
