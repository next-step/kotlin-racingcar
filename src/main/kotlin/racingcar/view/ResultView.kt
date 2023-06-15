package racingcar.view

import racingcar.domain.record.RacingRecord

object ResultView {

    private fun outputPosition(carPosition: Int) {
        println("-".repeat(carPosition))
    }

    fun outputResult(racingRecord: RacingRecord) {
        val carCount = racingRecord.carRecords.size
        val tryCount = racingRecord.carRecords.first().record.size

        println("실행 결과")
        (0 until tryCount).forEach { lap ->
            racingRecord.carRecords.forEach { carRecord ->
                outputPosition(carRecord.record[lap])
            }
            println()
        }
    }
}
