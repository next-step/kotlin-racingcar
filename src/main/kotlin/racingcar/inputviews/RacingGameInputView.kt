package racingcar.inputviews

import racingcar.dtos.GameInput

class RacingGameInputView : InputView {
    override fun receiveInput(): GameInput {
        val carNames = receiveCarNames()
        val numberOfRounds = receiveNumberOfRounds()

        return GameInput(carNames, numberOfRounds)
    }

    @Throws(IllegalArgumentException::class)
    private fun receiveCarNames(): List<String> {
        println(GET_CAR_NAMES_MESSAGE)
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MESSAGE }
        return input.split(CAR_NAMES_SPLIT_DELIMITER)
    }

    @Throws(IllegalArgumentException::class)
    private fun receiveNumberOfRounds(): Int {
        println(GET_NUMBER_OF_ROUNDS_MESSAGE)
        val input = readLine()?.toIntOrNull() ?: 0
        require(input < 0) { INVALID_INT_ERROR_MESSAGE }
        return input
    }

    companion object {
        private const val CAR_NAMES_SPLIT_DELIMITER = ","
        private const val GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val GET_NUMBER_OF_ROUNDS_MESSAGE = "시도할 횟수는 몇 회 인가요?"
        private const val EMPTY_STRING_ERROR_MESSAGE = "입력이 비어있습니다."
        private const val INVALID_INT_ERROR_MESSAGE = "입력은 0 보다 큰 정수이어야 합니다."
    }
}
