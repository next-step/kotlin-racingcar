package racingcars.view

class InputView(private val inputProvider: () -> String) {
    fun getNumberOfCars(): Int {
        println(NUMBER_OF_CARS)
        return getUserInputOrThrow()
    }

    fun getAttemptCount(): Int {
        println(ATTEMPT_COUNT)
        return getUserInputOrThrow()
    }

    fun getCarNames(): String {
        println(CAR_NAME)
        return inputProvider()
    }

    private fun getUserInputOrThrow(): Int {
        val input = inputProvider()
        return validInputToInt(input)
    }

    private fun validInputToInt(userInput: String?): Int {
        return userInput?.toIntOrNull()
            ?.takeIf { it >= MINIMUM_INPUT_NUMBER }
            ?: throw IllegalArgumentException("유효한 값을 입력해주세요")
    }

    companion object {
        private const val NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?"
        private const val CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"
        private const val MINIMUM_INPUT_NUMBER = 1
    }
}
