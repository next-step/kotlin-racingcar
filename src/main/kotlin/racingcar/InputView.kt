package racingcar

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return getNumberInput()
    }

    fun getGameCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getNumberInput()
    }

    private fun getNumberInput(): Int {
        return requireNotNull(readln().toIntOrNull()) { "숫자를 입력해주세요." }
    }
}
