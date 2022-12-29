package util.racing.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    @DisplayName("0부터 9사이의 값이 나온다.")
    @Test
    fun generateTest() {
        val numberGenerator: NumberGenerator = RandomNumberGenerator()

        assertThat(numberGenerator.generate()).isBetween(0, 9)
    }
}
