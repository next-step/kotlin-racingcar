package racinggame.domain.employee

import racinggame.domain.field.RacingFieldMiniMap
import racinggame.domain.player.toUser
import racinggame.domain.record.RacingRecordBook
import racinggame.domain.record.RacingRecordPaper
import racinggame.domain.record.RacingRecordPaperList

class RacingHistoryRecoder {

    private val totalRacingRecordPaperList = mutableListOf<RacingRecordPaperList>()

    fun capture(racingFieldMiniMap: RacingFieldMiniMap) {
        val racingHistories = racingFieldMiniMap.racingFieldMap
            .values
            .mapNotNull { field -> field.racingCar.racer?.let { it to field.moveDistance } }
            .map { (racer, moveDistance) -> RacingRecordPaper(racer.toUser(), moveDistance) }
        totalRacingRecordPaperList.add(RacingRecordPaperList(racingHistories))
    }

    fun createBook(): RacingRecordBook {
        return RacingRecordBook(totalRacingRecordPaperList)
    }
}
