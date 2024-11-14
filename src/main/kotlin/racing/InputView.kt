package racing

interface InputView {
    fun askCarCount()

    fun askTryCount()

    fun inputCount(count: String?): Int
}
