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
            .map { field -> field.racingCar.racer to field.moveDistance }
            .sortedBy { (racer, _) -> racer.ordinal }
            .map { (racer, moveDistance) -> RacingRecordPaper(racer.toUser(), moveDistance) }
        totalRacingRecordPaperList.add(RacingRecordPaperList(racingHistories))
    }

    fun createBook(): RacingRecordBook {
        return RacingRecordBook(totalRacingRecordPaperList)
    }
}
