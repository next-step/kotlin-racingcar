package racinggame.domain.judge

import racinggame.domain.record.RacingRecordBook

class Judge {

    fun evaluate(racingRecordBook: RacingRecordBook): EvaluationResult {
        val finalRoundRecords = racingRecordBook.totalRacingRecordPaperList
            .last()
            .list
        val maxMoveDistance = finalRoundRecords.maxOf { racingRecord ->
            racingRecord.moveDistance.value
        }
        val winners = finalRoundRecords
            .filter { racingRecord -> racingRecord.moveDistance.value >= maxMoveDistance }
            .map { racingRecord -> racingRecord.user }

        return EvaluationResult(winners = winners)
    }
}
