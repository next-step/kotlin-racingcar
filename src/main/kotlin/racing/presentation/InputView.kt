package racing.presentation

class InputView {
    fun inputCarNumber(): String? {
        println("자동차 수를 입력하세요")
        return readLine()
    }

    fun inputAttempt(): String? {
        println("이동 횟수를 입력하세요")
        return readLine()
    }
}
