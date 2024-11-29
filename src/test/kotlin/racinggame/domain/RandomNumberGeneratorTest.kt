package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RandomNumberGeneratorTest {
    @Test
    fun `generate should return a number between 0 and 9`() {
        val result = RandomNumberGenerator.generate()
        val actual = result in 0..9

        assertThat(actual).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `generated number should be in the valid range`(expected: Int) {
        val numberSet = mutableSetOf<Int>()
        repeat(100) {
            numberSet.add(RandomNumberGenerator.generate())
        }

        assertTrue(numberSet.contains(expected), "Number $expected was not generated")
    }
}
