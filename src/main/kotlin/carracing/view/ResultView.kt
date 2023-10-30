package carracing.view

import carracing.dto.RacingRound

class ResultView {
    fun printResult(list: List<RacingRound>) {
        println(INIT_RESULT)
        list.forEach {
            it.result.forEach {
                println(DASH.repeat(it.position))
            }
            println()
        }
    }

    companion object {
        private const val DASH = "-"
        private const val INIT_RESULT = "실행 결과"
    }
}
