package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DivisionCalculatorTest {

    @DisplayName("나눗셈 계산")
    @ParameterizedTest
    @CsvSource(value = ["3,1:3", "6,3:2", "50,5:10"], delimiter = ':')
    fun `sut returns addition`(expression: String, expected: Int) {
        // Arrange
        val numbers = expression.split(",")
        val first = numbers[0].toInt()
        val second = numbers[1].toInt()

        // Act
        val sut = DivisionCalculator()
        val result = sut.calculate(first, second)

        // Assert
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
