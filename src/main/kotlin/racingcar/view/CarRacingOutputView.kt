package racingcar.view

object CarRacingOutputView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val ROUND_SEPARATOR = "\n"

    fun draw(racingOutput: CarRacingOutput) {
        val carPositionsByRoundIndOrder = racingOutput.carPositionsByRoundInOrder
        carPositionsByRoundIndOrder.forEachIndexed() { index, carPositions ->
            val message = if (index == 0) RESULT_MESSAGE else ROUND_SEPARATOR
            println(message)
            print(drawRoundResult(carPositions))
        }
    }

    private fun drawRoundResult(carPositions: List<Int>): String =
        carPositions.joinToString("\n") { drawLine((it)) }

    private fun drawLine(size: Int) = "-".repeat(size)
}
