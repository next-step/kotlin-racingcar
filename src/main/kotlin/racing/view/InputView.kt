package racing.view

data class InputView(
    val numberOfCar: Int,
    val round: Int
) {
    companion object {
        private const val NUMBER_OF_CAR_QUESTION_TEMPLATE = "자동차 대수는 몇 대인가요?"
        private const val ATTEMPT_COUNT_QUESTION_TEMPLATE = "시도할 횟수는 몇 회인가요?"

        fun input(): InputView {
            val numberOfCar = inputNumberOfCar()
            val attempt = inputAttemptCount()

            return InputView(numberOfCar = numberOfCar, round = attempt)
        }

        private fun inputNumberOfCar(): Int {
            println(NUMBER_OF_CAR_QUESTION_TEMPLATE)
            return readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
        }

        private fun inputAttemptCount(): Int {
            println(ATTEMPT_COUNT_QUESTION_TEMPLATE)
            return readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
        }
    }
}
