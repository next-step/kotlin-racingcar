package racingcar.inputviews

import racingcar.dtos.GameInput

class RacingGameInputView : InputView {
    override fun receiveInput(): GameInput {
        val carNames = receiveCarNames()
        val numberOfRounds = receiveNumberOfRounds()

        return GameInput(carNames, numberOfRounds)
    }

    private fun receiveCarNames(): List<String> {
        println(GET_CAR_NAMES_MESSAGE)
        return receiveStr().split(CAR_NAMES_SPLIT_DELIMITER)
    }

    @Throws(IllegalArgumentException::class)
    private fun receiveStr(): String {
        val input = readLine()
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(EMPTY_STRING_ERROR_MESSAGE)
        }
        return input
    }

    private fun receiveNumberOfRounds(): Int {
        println(GET_NUMBER_OF_ROUNDS_MESSAGE)
        val input = receiveInt()
        validateNumberOfRounds(input)
        return input
    }

    @Throws(IllegalArgumentException::class)
    private fun receiveInt(): Int {
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(NOT_A_NUMBER_ERROR_MESSAGE)
    }

    @Throws(IllegalArgumentException::class)
    private fun validateNumberOfRounds(input: Int) {
        if (input < 0) {
            throw IllegalArgumentException(INVALID_INT_ERROR_MESSAGE)
        }
    }

    companion object {
        const val GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val GET_NUMBER_OF_ROUNDS_MESSAGE = "시도할 횟수는 몇 회 인가요?"
        const val EMPTY_STRING_ERROR_MESSAGE = "입력이 비어있습니다."
        const val NOT_A_NUMBER_ERROR_MESSAGE = "입력이 정수가 아닙니다."
        const val CAR_NAMES_SPLIT_DELIMITER = ","
        const val INVALID_INT_ERROR_MESSAGE = "입력은 0 보다 큰 정수이어야 합니다."
    }
}
