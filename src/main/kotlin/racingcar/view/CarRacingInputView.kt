package racingcar.view

object CarRacingInputView {
    private const val CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?"
    private const val TRY_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?"

    fun getInputForStart(): CarRacingInput = CarRacingInput(
        carCount = getCarCountInput(),
        tryCount = getTryCountInput(),
    )

    private fun getCarCountInput(): Int = toInt(InputView.readInput(CAR_COUNT_QUESTION))

    private fun getTryCountInput(): Int = toInt(InputView.readInput(TRY_COUNT_QUESTION))

    private fun toInt(inputString: String?): Int {
        require(!inputString.isNullOrBlank()) { "입력 값이 없습니다" }
        return inputString.toIntOrNull() ?: throw IllegalArgumentException("입력 값은 숫자여야 합니다")
    }
}
