package racing.domain.strategy

fun interface Generator<T> {
    fun generate(): T
}
