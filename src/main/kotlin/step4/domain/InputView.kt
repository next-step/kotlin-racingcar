package step4.domain

interface InputView<out T> {
    fun enter(): T
}
