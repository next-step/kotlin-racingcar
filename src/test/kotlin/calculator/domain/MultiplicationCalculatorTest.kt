package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MultiplicationCalculatorTest {

    @DisplayName("곱셈 계산")
    @ParameterizedTest
    @CsvSource(value = ["1,1:1", "3,4:12", "10,10:100"], delimiter = ':')
    fun `sut returns addition`(expression: String, expected: Int) {
        // Arrange
        val numbers = expression.split(",")
        val first = numbers[0].toInt()
        val second = numbers[1].toInt()

        // Act
        val sut = MultiplicationCalculator()
        val result = sut.calculate(first, second)

        // Assert
        assertThat(result).isEqualTo(expected)
    }
}
