package racingcar.view

import racingcar.domain.result.CarRacingResult

object CarRacingOutputView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val ROUND_SEPARATOR = "\n"

    fun draw(results: List<CarRacingResult>) {
        results.forEachIndexed { index, result ->
            val message = if (index == 0) RESULT_MESSAGE else ROUND_SEPARATOR
            println(message)
            print(drawResult(result))
        }
    }

    private fun drawResult(result: CarRacingResult): String =
        result.cars.joinToString("\n") { drawLine(it.position) }

    private fun drawLine(size: Int) = "-".repeat(size)
}
