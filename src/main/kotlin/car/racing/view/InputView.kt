package car.racing.view

class InputView {

    fun inputCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")

        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(ACCEPT_ONLY_NUMBER)
    }

    fun inputTurnCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(ACCEPT_ONLY_NUMBER)
    }

    companion object {
        private const val ACCEPT_ONLY_NUMBER = "숫자만 입력가능합니다."
    }
}
