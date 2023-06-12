package racing.ui

import racing.domain.RacingPhaseRecords

object OutputView {

    fun print(racingPhaseRecords: List<RacingPhaseRecords>) {
        println("실행 결과")
        racingPhaseRecords.forEach { phaseRecords ->
            print(phaseRecords)
            println()
        }
    }

    private fun print(racingPhaseRecords: RacingPhaseRecords) {
        racingPhaseRecords.records.forEach { record ->
            print("${record.carName} : ")
            println("-".repeat(record.distance))
        }
    }
}
