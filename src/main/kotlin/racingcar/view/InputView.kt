package racingcar.view

object InputView {
    fun readInput(message: String? = null): String {
        message?.run { println(message) }
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    }
}
