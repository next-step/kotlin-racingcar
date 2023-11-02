package racingcar

fun createStubRandomGenerator(vararg values: Int): RandomGenerator {
    val numbers = values.iterator()
    return RandomGenerator { numbers.next() }
}
