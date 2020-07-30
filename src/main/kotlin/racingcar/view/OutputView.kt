package racingcar.view

import racingcar.domain.RacingRecord
import racingcar.domain.RacingResult

fun printRacingResult(racingResults: List<RacingResult>) {
    println("실행 결과")
    racingResults.forEach { printRacingRecords(it.records) }
}

private fun printRacingRecords(racingRecords: List<RacingRecord>) {
    racingRecords.forEach { printTrack(it) }
    println()
}

private fun printTrack(racingRecord: RacingRecord) {
    print("${racingRecord.carName} : ")
    repeat(racingRecord.carDistance) { print("-") }
    println()
}

fun printWinners(winners: List<String>) {
    println("${winners.joinToString(", ")}가 최종 우승했습니다.")
}
