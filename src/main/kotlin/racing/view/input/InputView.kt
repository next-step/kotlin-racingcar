package racing.view.input

abstract class InputView<T> {
    abstract val message: String
    abstract var value: T

    protected fun renderMessage() {
        println(message)
    }
}
