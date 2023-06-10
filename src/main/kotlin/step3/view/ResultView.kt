package step3.view

import step3.domain.RacingRecord

class ResultView {
    fun outputRacingResult(racingRecord: RacingRecord) {
        racingRecord.record.forEach { attempt ->
            println("####")
            attempt.forEach { position ->
                println("-".repeat(position))
            }
        }
    }
}
