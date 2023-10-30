package carracing.view

import carracing.dto.RacingRound

class ResultView {
    fun printResult(racingResult: List<RacingRound>) {
        println(INIT_RESULT)
        racingResult.forEach { racing ->
            racing.result.forEach {
                println(DASH.repeat(it.position))
            }
            println()
        }
    }

    companion object {
        private const val DASH = "-"
        private const val INIT_RESULT = "\n실행 결과"
    }
}
