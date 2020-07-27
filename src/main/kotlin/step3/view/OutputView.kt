package step3.view

import step3.RacingResult

fun printRacingResults(racingResults: List<RacingResult>) {
    println("실행 결과")
    racingResults.forEach { printRacingResult(it) }
}

private fun printRacingResult(racingResult: RacingResult) {
    racingResult.distances.forEach { printTrack(it) }
    println()
}

private fun printTrack(distance: Int) {
    repeat(distance) { print("-") }
    println()
}
