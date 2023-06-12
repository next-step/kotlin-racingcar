package racing.ui

import racing.domain.RacingPhaseRecords

object OutputView {

    fun print(racingPhaseRecords: List<RacingPhaseRecords>) {
        println("실행 결과")
        racingPhaseRecords.forEach { phaseRecord ->
            phaseRecord.records.forEach { record ->
                println("-".repeat(record.distance))
            }
            println()
        }
    }
}
