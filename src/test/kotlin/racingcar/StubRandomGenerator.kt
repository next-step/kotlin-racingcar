package racingcar

import io.mockk.every
import io.mockk.mockk

fun createStubRandomGenerator(vararg values: Int): RandomGenerator {
    val randomGenerator = mockk<RandomGenerator>()
    val numbers = values.iterator()
    every { randomGenerator.generate() }.answers { numbers.next() }
    return randomGenerator
}
