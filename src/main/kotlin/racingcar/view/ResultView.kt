package racingcar.view

import racingcar.domain.GameRoundResult
import racingcar.domain.RacingCar

object ResultView {

    private const val CAR_POSITION_INDICATOR = "-"
    private const val RESULT_TITLE = "실행 결과"
    private const val WINNER_SEPARATOR = ", "

    fun writeRoundResults(gameRoundResults: List<GameRoundResult>) {
        println(RESULT_TITLE)
        gameRoundResults.forEach { roundResult ->
            roundResult.cars.forEach {
                println("${it.nickname.value} : ${CAR_POSITION_INDICATOR.repeat(it.position.value)}")
            }
            println()
        }
    }

    fun writeWinners(winners: List<RacingCar>) {
        println()
        println("${winners.joinToString(WINNER_SEPARATOR) { it.nickname.value }}가 최종 우승했습니다.")
    }
}
