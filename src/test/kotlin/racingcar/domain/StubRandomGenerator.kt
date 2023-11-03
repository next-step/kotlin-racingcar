package racingcar.domain

fun createStubRandomGenerator(vararg values: Int): NumberGenerator {
    return createStubRandomGenerator(values.toList())
}

fun createStubRandomGenerator(values: List<Int>): NumberGenerator {
    val numbers = values.iterator()
    return NumberGenerator { numbers.next() }
}
