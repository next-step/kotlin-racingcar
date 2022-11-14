package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomTest {

    @Test
    fun `항상 0-9사이의 값이 나온다`() {
        // Arrange
        val randomGeneratorNumber = RandomGeneratorNumber()
        // Act
        val generatedNumber = randomGeneratorNumber.generate()

        // Assert
        assertThat(generatedNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9)
    }
}
