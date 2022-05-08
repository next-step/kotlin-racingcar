package racing.view

object InputView {

    fun printCarCountInputMessage() {
        println("자동차 대수는 몇 대인가요?")
    }

    fun printTryCountInputMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun inputCarCount(): Int {
        return readln().toInt()
    }

    fun inputTryCount(): Int {
        return readln().toInt()
    }
}
