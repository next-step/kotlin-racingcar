package racinggame.domain.record

data class RacingRecordPaperList(
    val list: List<RacingRecordPaper>
) {
    private val maxMoveDistance = list.maxOf { racingRecord ->
        racingRecord.moveDistance.value
    }
    val maxMoveDistanceUsers = list
        .filter { racingRecord -> racingRecord.moveDistance.value == maxMoveDistance }
        .map { racingRecordPaper -> racingRecordPaper.user }
}
