package racingcar.view

object CarRacingInputView {
    private const val CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val TRY_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?"
    private const val CAR_NAME_DELIMITER = ","

    fun getInputWithCarName() {
        getCarNameInput()
    }

    private fun getCarNameInput() =
        toStringList(InputView.readInput(CAR_NAME_QUESTION), CAR_NAME_DELIMITER)

    private fun getTryCountInput(): Int = toInt(InputView.readInput(TRY_COUNT_QUESTION))

    private fun toInt(inputString: String): Int =
        inputString.toIntOrNull() ?: throw IllegalArgumentException("입력 값은 숫자여야 합니다")

    private fun toStringList(inputString: String, delimiter: String) =
        inputString.split(delimiter)
}
