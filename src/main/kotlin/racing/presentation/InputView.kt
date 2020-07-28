package racing.presentation

class InputView {
    fun inputAttempt(): String? {
        println("이동 횟수를 입력하세요")
        return readLine()
    }

    fun inputNames(): String? {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        return readLine()
    }
}
