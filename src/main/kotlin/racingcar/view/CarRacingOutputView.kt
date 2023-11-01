package racingcar.view

import racingcar.controller.CarRacingResponse
import racingcar.domain.car.CarName
import racingcar.domain.result.CarRacingResult

object CarRacingOutputView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val WINNER_MESSAGE = "가 최종 우승했습니다."
    private const val ROUND_SEPARATOR = "\n"
    private const val ONE_POSITION_SYMBOL = "-"
    private const val WINNER_SEPARATOR = ","

    fun draw(
        response: CarRacingResponse,
    ) {
        println(RESULT_MESSAGE)
        response.results.forEach { result ->
            println(drawResult(result))
            println()
        }
        println(drawWinner(response.winners))
    }

    private fun drawResult(result: CarRacingResult): String =
        result.cars.joinToString(ROUND_SEPARATOR) { "${it.name.value} : ${drawPosition(it.position)}" }

    private fun drawPosition(size: Int) = ONE_POSITION_SYMBOL.repeat(size)

    private fun drawWinner(winners: List<CarName>) =
        winners.joinToString(WINNER_SEPARATOR) { it.value } + WINNER_MESSAGE
}
