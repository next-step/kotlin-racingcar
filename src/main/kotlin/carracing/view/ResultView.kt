package carracing.view

import carracing.dto.Car
import carracing.dto.RacingRound

class ResultView {
    fun printResult(racingResult: List<RacingRound>) {
        println(INIT_RESULT)
        racingResult.forEach { round ->
            round.roundResult.forEach {
                val name = it.name
                val value = DASH.repeat(it.position)
                println("$name : $value")
            }
            println()
        }
    }

    fun printWinners(result: List<Car>) {
        val maxPosition = result.maxOf { it.position }
        val winners = result.filter { it.position == maxPosition }.joinToString(", ") { it.name }
        println("$winners 가 최종 우승했습니다.")
    }

    companion object {
        private const val DASH = "-"
        private const val INIT_RESULT = "\n실행 결과"
    }
}
