package race

data class RaceResult(
    val turns: List<TurnInfo>,
) {
    fun latestCarPositions() = turns.last()
        .carPositions

    fun appendTurn(turn: TurnInfo) = copy(turns = turns.plus(turn))

    companion object {
        fun getInitialRaceResult(startInformation: RaceStartInformation): RaceResult {
            return RaceResult(listOf(TurnInfo.getInitialTurn(startInformation)))
        }
    }
}
