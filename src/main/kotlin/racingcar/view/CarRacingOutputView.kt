package racingcar.view

object CarRacingOutputView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val ROUND_SEPARATOR = "\n"

    fun draw(racingResult: List<CarRacingRoundOutput>) {
        racingResult.forEachIndexed() { index, roundResult ->
            val message = if (index == 0) RESULT_MESSAGE else ROUND_SEPARATOR
            println(message)
            print(roundResult.draw())
        }
    }
}
