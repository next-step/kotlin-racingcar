package racinggame.domain.record

import racinggame.domain.field.RacingFieldMiniMap
import racinggame.domain.player.toUser

class RacingHistoryRecoder {

    private val totalRacingRecordPaperList = mutableListOf<RacingRecordPaperList>()

    fun capture(racingFieldMiniMap: RacingFieldMiniMap) {
        val racingHistories = racingFieldMiniMap.racingFieldMap
            .values
            .sortedBy { field -> field.racingCar.racer.ordinal }
            .map { field -> RacingRecordPaper(field.racingCar.racer.toUser(), field.moveDistance) }
        totalRacingRecordPaperList.add(RacingRecordPaperList(racingHistories))
    }

    fun createBook(): RacingRecordBook {
        return RacingRecordBook(totalRacingRecordPaperList)
    }
}
