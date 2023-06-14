package racinggame.domain.record

data class RacingRecordBook(
    val totalRacingRecordPaperList: List<RacingRecordPaperList>,
) {
    val finalRound = totalRacingRecordPaperList.last()
}
