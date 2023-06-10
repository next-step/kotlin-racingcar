package racing

object OutputView {

    fun output(racingPhasedRecords: List<RacingPhasedRecord>) {
        println("실행 결과")
        racingPhasedRecords.forEach { phaseRecord ->
            phaseRecord.records.forEach { record ->
                println("-".repeat(record))
            }
            println()
        }
    }
}
