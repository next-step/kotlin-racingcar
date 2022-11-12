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
}
