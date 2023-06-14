package study.racing.inputview

fun interface InputView<T : Any> {
    fun receive(): T
}
