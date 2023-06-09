package race

data class RaceResult(
    val turns: List<TurnInfo>,
) {
    fun latestTurn() = turns.last()

    fun appendTurn(turn: TurnInfo) = copy(turns = turns.plus(turn))

    companion object {
        fun getInitialRaceResult(startInformation: RaceStartInformation): RaceResult {
            return RaceResult(listOf(InitialTurn(startInformation)))
        }
    }
}
