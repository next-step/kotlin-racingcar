package car.racing.usecase

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NumberRandomGeneratorTest {

    @Test
    fun `여러번 반복을 통한 Range 검증`() {
        repeat(100) {
            val randomGenerator = NumberRandomGenerator()
            val result = randomGenerator.generate()

            assertTrue(NumberRandomGenerator.MIN_VALUE <= result)
            assertTrue(NumberRandomGenerator.MAX_VALUE > result)
        }
    }
}
