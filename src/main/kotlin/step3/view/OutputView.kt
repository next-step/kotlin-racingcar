package step3.view

import step3.RacingResult
import step3.RacingTrack

fun printRacingResults(racingResults: List<RacingResult>) {
    println("실행 결과")
    racingResults.forEach { printRacingResult(it) }
    printWinners(racingResults.last().findCurrentWinners())
}

private fun printRacingResult(racingResult: RacingResult) {
    racingResult.racingTracks.forEach { printTrack(it) }
    println()
}

private fun printTrack(racingTrack: RacingTrack) {
    print("${racingTrack.carName} : ")
    repeat(racingTrack.carDistance) { print("-") }
    println()
}

private fun printWinners(winners: List<String>) {
    println("${winners.joinToString(", ")}가 최종 우승했습니다.")
}
