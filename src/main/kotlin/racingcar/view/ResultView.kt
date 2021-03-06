package racingcar.view

import racingcar.racing.RacingResults
import racingcar.racing.RacingTrial
import racingcar.racing.Record

class ResultView {
    fun print(results: RacingResults) {
        println("실행 결과")
        results.trials.forEach(this::printTrial)
    }

    private fun printTrial(trial: RacingTrial) {
        trial.records.forEach(this::printCarRecord)
        println()
    }

    private fun printCarRecord(record: Record) {
        println("${record.name} : ${"-".repeat(START_LINE + record.location.value)}")
    }

    companion object {
        const val START_LINE = 1
    }
}
