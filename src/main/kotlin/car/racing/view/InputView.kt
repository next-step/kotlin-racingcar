package car.racing.view

class InputView {

    fun inputCarCount(): List<String> {
        println(INPUT_CAR_NAME)
        val inputValue = readLine() ?: ""

        return inputValue.split(",")
    }

    fun inputTurnCount(): Int {
        println(INPUT_TURN_COUNT)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(ACCEPT_ONLY_NUMBER)
    }

    companion object {
        private const val INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val INPUT_TURN_COUNT = "시도할 횟수는 몇 회인가요?"
        private const val ACCEPT_ONLY_NUMBER = "숫자만 입력가능합니다."
    }
}
