package car.racing.view

class InputView {

    fun inputCarCount(): Int {
        println(INPUT_CAR_COUNT)

        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(ACCEPT_ONLY_NUMBER)
    }

    fun inputTurnCount(): Int {
        println(INPUT_TURN_COUNT)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(ACCEPT_ONLY_NUMBER)
    }

    companion object {
        private const val INPUT_CAR_COUNT = "자동차 대수는 몇 대인가요?"
        private const val INPUT_TURN_COUNT = "시도할 횟수는 몇 회인가요?"
        private const val ACCEPT_ONLY_NUMBER = "숫자만 입력가능합니다."
    }
}
