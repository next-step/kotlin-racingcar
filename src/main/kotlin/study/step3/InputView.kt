package study.step3

class InputView {

    fun inputCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toInt() ?: 0
    }

    fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: 0
    }
}
