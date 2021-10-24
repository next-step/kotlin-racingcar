package racingcar.inputviews

class RacingGameInputView : InputView {
    override fun receiveInput(): GameInput {
        val numberOfCars = receiveNumberOfCars()
        val numberOfRounds = receiveNumberOfRounds()

        return GameInput(numberOfCars, numberOfRounds)
    }

    private fun receiveNumberOfCars(): Int {
        println(GET_NUMBER_OF_CARS_MESSAGE)
        return receiveInt()
    }

    private fun receiveNumberOfRounds(): Int {
        println(GET_NUMBER_OF_ROUNDS_MESSAGE)
        return receiveInt()
    }

    @Throws(IllegalArgumentException::class)
    private fun receiveInt(): Int {
        val intInput = readLine()?.toIntOrNull() ?: throw IllegalArgumentException(NOT_A_NUMBER_ERROR_MESSAGE)
        validateInput(intInput)
        return intInput
    }

    @Throws(IllegalArgumentException::class)
    private fun validateInput(input: Int) {
        if (input < 0) {
            throw IllegalArgumentException(INVALID_INT_ERROR_MESSAGE)
        }
    }

    companion object {
        const val GET_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?"
        const val GET_NUMBER_OF_ROUNDS_MESSAGE = "시도할 횟수는 몇 회 인가요?"
        const val NOT_A_NUMBER_ERROR_MESSAGE = "입력이 정수가 아닙니다."
        const val INVALID_INT_ERROR_MESSAGE = "입력은 0 보다 큰 정수이어야 합니다."
    }
}
