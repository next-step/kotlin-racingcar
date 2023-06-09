package racing

object OutputView {

    fun output(racing: Racing) {
        println("실행 결과")
        output(racing.racingPhasedRecords)
    }

    private fun output(racingPhasedRecords: List<RacingPhasedRecord>) {
        racingPhasedRecords.forEach { phaseRecord ->
            phaseRecord.records.forEach { record ->
                repeat(record) { print("-") }
                println()
            }
            println()
        }
    }
}
