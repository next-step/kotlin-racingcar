package racingcar.view

import racingcar.domain.car.CarName
import racingcar.domain.result.CarRacingResult

object CarRacingOutputView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val WINNER_MESSAGE = "가 최종 우승했습니다."
    private const val ROUND_SEPARATOR = "\n"

    fun draw(
        results: List<CarRacingResult>,
        winners: List<CarName>
    ) {
        results.forEachIndexed { index, result ->
            val message = if (index == 0) RESULT_MESSAGE else ROUND_SEPARATOR
            println(message)
            println(drawResult(result))
            println(drawWinner(winners))
        }
    }

    private fun drawResult(result: CarRacingResult): String =
        result.cars.joinToString("\n") { "${it.name.value} : ${drawLine(it.position)}" }

    private fun drawLine(size: Int) = "-".repeat(size)

    private fun drawWinner(winners: List<CarName>) =
        winners.joinToString("") { it.value } + WINNER_MESSAGE
}
