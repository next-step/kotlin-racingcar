package util.racing.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    @Test
    fun `0부터 9사이의 값이 나온다`() {
        val numberGenerator: NumberGenerator = RandomNumberGenerator()

        assertThat(numberGenerator.generate()).isBetween(0, 9)
    }
}
