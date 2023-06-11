package racingcar

object InputView {

    fun inputCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")

        return readlnOrNull()?.toInt() ?: run {
            println("필수로 입력해야 하는 값입니다.")
            inputCarCount()
        }
    }

    fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return readlnOrNull()?.toInt() ?: run {
            println("필수로 입력해야 하는 값입니다.")
            inputTryCount()
        }
    }
}
