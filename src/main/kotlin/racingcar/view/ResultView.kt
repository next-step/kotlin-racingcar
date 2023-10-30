package racingcar.view

import racingcar.domain.GameRoundResult

object ResultView {

    private const val CAR_POSITION_INDICATOR = "-"
    private const val RESULT_TITLE = "실행 결과"

    fun writeRoundResults(gameRoundResults: List<GameRoundResult>) {
        println(RESULT_TITLE)
        gameRoundResults.forEach { roundResult ->
            roundResult.cars.forEach {
                println(CAR_POSITION_INDICATOR.repeat(it.position.value))
            }
            println()
        }
    }
}
