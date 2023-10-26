package racingcar.view

object InputView {
    fun readInput(message: String? = null): String? {
        message?.run { println(message) }
        return readlnOrNull()
    }
}
