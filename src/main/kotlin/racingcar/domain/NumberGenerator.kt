package racingcar.domain

fun interface NumberGenerator<TYPE: Number> {

    fun apply(start: TYPE, end: TYPE): TYPE
}
