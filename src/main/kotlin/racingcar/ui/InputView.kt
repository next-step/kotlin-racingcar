package racingcar.ui

object InputView {
    fun inputCarNumber(): Int {
        println(MessageCode.CarNumberQuestion.message)
        return requireNotNull(readLine()?.toInt())
    }

    fun inputTryNumber(): Int {
        println(MessageCode.TryNumberQuestion.message)
        return requireNotNull(readLine()?.toInt())
    }
}
