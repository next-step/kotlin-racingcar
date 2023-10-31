package racingcar.domain

fun interface RandomGenerator<TYPE> {

    fun apply(start: TYPE, end: TYPE): TYPE
}
