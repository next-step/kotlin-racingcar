package step3.view

import step3.RacingResult
import step3.RacingRecord

fun printRacingResult(racingResult: RacingResult) {
    println("실행 결과")
    printRacingRecords(racingResult.records)
    printWinners(racingResult.winners)
}

private fun printRacingRecords(racingRecords: List<RacingRecord>) {
    racingRecords.forEach { printRacingRecord(it) }
    println()
}

private fun printRacingRecord(racingRecord: RacingRecord) {
    racingRecord.value.keys.forEach { printTrack(it, racingRecord.value[it]!!) }
    println()
}

private fun printTrack(carName: String, distance: Int) {
    print("$carName : ")
    repeat(distance) { print("-") }
    println()
}

private fun printWinners(winners: List<String>) {
    println("${winners.joinToString(", ")}가 최종 우승했습니다.")
}
