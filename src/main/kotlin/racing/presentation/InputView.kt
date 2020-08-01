package racing.presentation

class InputView {
    fun inputAttempt(): String {
        println("이동 횟수를 입력하세요")

        val string = readLine()
        if (string.isNullOrBlank()) {
            return "0"
        }
        return string
    }

    fun inputNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val string = readLine()
        if (string.isNullOrBlank()) {
            return ""
        }
        return string
    }
}
