package racingcar.ui

import racingcar.dto.RacingResultDTO

object ResultView {

    private const val DISTANCE_CHARACTER = "-"

    fun racing(results: List<RacingResultDTO>) {
        results.forEach {
            println("${it.carName} : ${DISTANCE_CHARACTER.repeat(it.distance)}")
        }
        println()
    }

    fun winners(winners: List<RacingResultDTO>) {
        val winnerNames = winners.map { it.carName }.toList()
        println("${winnerNames.joinToString(",")}가 최종 우승했습니다.")
    }
}
