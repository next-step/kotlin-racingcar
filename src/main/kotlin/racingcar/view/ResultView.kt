package racingcar.view

import racingcar.domain.record.RacingRecord

object ResultView {

    fun outputPosition(carPosition: Int) {
        print("-".repeat(carPosition))
        println()
    }

    fun outputResult(racingRecord: RacingRecord) {
        val carCount = racingRecord.carRecords.size
        val tryCount = racingRecord.carRecords.first().records.size

        println("실행 결과")
        (0 until tryCount).forEach { lap ->
            racingRecord.carRecords.forEach { carRecord ->
                println("-".repeat(carRecord.records[lap]))
            }
            println()
        }
    }
}
