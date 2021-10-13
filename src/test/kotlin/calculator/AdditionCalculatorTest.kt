package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AdditionCalculatorTest {

    @DisplayName("덧셈 계산")
    @ParameterizedTest
    @CsvSource(value = ["1,2:3", "3,4:7", "4,10:14"], delimiter = ':')
    fun `sut returns addition`(expression: String, expected: Int) {
        // Arrange
        val numbers = expression.split(",")
        val first = numbers[0].toInt()
        val second = numbers[1].toInt()

        // Act
        val sut = AdditionCalculator()
        val result = sut.calculate(first, second)

        // Assert
        assertThat(result).isEqualTo(expected)
    }
}
