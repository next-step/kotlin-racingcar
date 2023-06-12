package racinggame.domain.record

import racinggame.domain.field.RacingFieldMiniMap

class RacingHistoryRecoder {

    private val totalRacingRecordPaperList = mutableListOf<RacingRecordPaperList>()

    fun capture(racingFieldMiniMap: RacingFieldMiniMap) {
        val racingHistories = racingFieldMiniMap.racingFieldMap
            .values
            .sortedBy { field -> field.racingCar.user.ordinal }
            .map { field -> RacingRecordPaper(field.racingCar.user, field.moveDistance) }
        totalRacingRecordPaperList.add(RacingRecordPaperList(racingHistories))
    }

    fun createBook(): RacingRecordBook {
        return RacingRecordBook(totalRacingRecordPaperList)
    }
}
