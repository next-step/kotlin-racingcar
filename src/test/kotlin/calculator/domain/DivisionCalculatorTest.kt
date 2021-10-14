package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `sut throw IllegalArgumentException when second number is zero`() {
        // Arrange
        val first = 3
        val second = 0

        // Act, Assert
        val sut = DivisionCalculator()
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                sut.calculate(first, second)
            }
    }
}
