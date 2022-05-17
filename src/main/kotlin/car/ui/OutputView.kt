package car.ui

import car.application.dto.RacingResult
import car.application.dto.RapResult
import car.application.dto.RapResults

private const val CAR_RESULT_POSITION = "-"

object OutputView {
    fun output(racingResult: RacingResult) {
        println("실행 결과")
        racingResult.results.forEach { printPerRap(it) }
        newLine()

        println("${racingResult.winners.joinToString(", ") { it.value }}가 최종 우승했습니다.")
    }

    private fun printPerRap(rapResults: RapResults) {
        rapResults.results.forEach { printRapResult(it) }
        newLine()
    }

    private fun printRapResult(rapResult: RapResult) {
        println("${rapResult.name.value} : ${CAR_RESULT_POSITION.repeat(rapResult.position.value)}")
    }

    private fun newLine() = println()
}
