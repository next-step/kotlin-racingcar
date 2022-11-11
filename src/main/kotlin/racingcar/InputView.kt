package racingcar

object InputView {
    fun readCarCount(): Int {
        print("자동차 대수는 몇 대인가요?")
        return readNumber()
    }

    fun readTryCount(): Int {
        print("시도할 횟수는 몇 회인가요?")
        return readNumber()
    }

    private fun readNumber() = readln().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
}
