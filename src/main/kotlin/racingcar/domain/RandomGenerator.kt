package racingcar.domain

abstract class RandomGenerator<TYPE>(
    private val start: TYPE,
    private val end: TYPE
) {
    fun generate() = generate(start, end)

    abstract fun generate(start: TYPE, end: TYPE) : TYPE
}
