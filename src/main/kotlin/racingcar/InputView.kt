package racingcar

object InputView {

    fun inputCarSize(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
