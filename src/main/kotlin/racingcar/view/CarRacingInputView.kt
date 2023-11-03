package racingcar.view

import racingcar.controller.CarRacingRequest

object CarRacingInputView {
    private const val CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ROUND_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?"
    private const val CAR_NAME_DELIMITER = ","
    fun getRequest(): CarRacingRequest = CarRacingRequest(
        carNames = getCarNameInput(),
        roundCount = getRoundCountInput()
    )

    private fun getCarNameInput() =
        toStringList(InputView.readInput(CAR_NAME_QUESTION), CAR_NAME_DELIMITER)

    private fun getRoundCountInput(): Int = toInt(InputView.readInput(ROUND_COUNT_QUESTION))

    private fun toInt(inputString: String): Int =
        inputString.toIntOrNull() ?: throw IllegalArgumentException("입력 값은 숫자여야 합니다")

    private fun toStringList(inputString: String, delimiter: String): List<String> =
        inputString.split(delimiter)
}
