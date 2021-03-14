package racingcar.view

import racingcar.domain.racing.RacingResults
import racingcar.domain.racing.RacingTrial
import racingcar.domain.racing.Record

class ResultView {
    fun print(results: RacingResults) {
        println("\n실행 결과")
        printTrials(results)
        printWinners(results)
    }

    private fun printTrials(results: RacingResults) {
        results.trials.forEach(this::printTrial)
    }

    private fun printTrial(trial: RacingTrial) {
        trial.records.forEach(this::printCarRecord)
        println()
    }

    private fun printCarRecord(record: Record) {
        println(makeCarRecordString(record))
    }

    private fun makeCarRecordString(record: Record) =
        "${record.name} : ${"-".repeat(record.location.value)}"

    private fun printWinners(results: RacingResults) {
        println(makeWinnerNoticeSentence(results.winnerRecords))
    }

    private fun makeWinnerNoticeSentence(winnerRecords: Collection<Record>): String =
        winnerRecords.joinToString { it.name.toString() } + WINNER_NOTICE_SUFFIX

    companion object {
        const val WINNER_NOTICE_SUFFIX = "가 최종 우승했습니다."
    }
}
