package racingcar.domain

fun createStubRandomGenerator(vararg values: Int): NumberGenerator {
    val numbers = values.iterator()
    return NumberGenerator { numbers.next() }
}
