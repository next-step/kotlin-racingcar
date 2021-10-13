package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SubtractionCalculatorTest {

    @DisplayName("뺄셈 계산")
    @ParameterizedTest
    @CsvSource(value = ["1,2:-1", "10,1:9", "5,5:0"], delimiter = ':')
    fun `sut returns subtraction`(expression: String, expected: Int) {
        // Arrange
        val numbers = expression.split(",")
        val first = numbers[0].toInt()
        val second = numbers[1].toInt()

        // Act
        val sut = SubtractionCalculator()
        val result = sut.calculate(first, second)

        // Assert
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
