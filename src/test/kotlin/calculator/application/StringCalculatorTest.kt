package calculator.application

import calculator.domain.CalculatorFactory
import calculator.exception.InvalidExpressionException
import calculator.exception.OperatorNotFoundException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringCalculatorTest {

    private lateinit var calculatorService: StringCalculator

    @DisplayName("올바른 식이 들어올 경우 계산 실행")
    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2:10", "1 + 2 * 6:18"], delimiter = ':')
    fun `sut returns correctly`(expression: String?, exprected: String) {
        // Arrange
        val calculators = CalculatorFactory.init()
        calculatorService = StringCalculator(calculators)

        // Act
        val sut = calculatorService.execute(expression)

        // Assert
        assertThat(sut).isEqualTo(exprected.toInt())
    }

    @DisplayName("유효하지 않은 연산자가 입력될 경우")
    @Test
    fun `sut throw OperatorNotFoundException when invalid operator`() {
        // Arrange
        val expression = "3 % 1"
        val calculators = CalculatorFactory.init()
        calculatorService = StringCalculator(calculators)

        // Act, Assert
        assertThatExceptionOfType(OperatorNotFoundException::class.java)
            .isThrownBy {
                calculatorService.execute(expression)
            }
    }

    @DisplayName("입력값이 null 혹은 빈값일 경우")
    @ParameterizedTest
    @NullAndEmptySource
    fun `sut throw InvalidExpressionException when expression is null and empty`(expression: String?) {
        // Arrange
        val calculators = CalculatorFactory.init()
        calculatorService = StringCalculator(calculators)

        // Act, Assert
        assertThatExceptionOfType(InvalidExpressionException::class.java)
            .isThrownBy {
                calculatorService.execute(expression)
            }
    }

    @DisplayName("0으로 숫자를 나눌 경우")
    @Test
    fun `sut throw IllegalArgumentException when second number is zero`() {
        // Arrange
        val expression = "3 / 0"
        val calculators = CalculatorFactory.init()
        calculatorService = StringCalculator(calculators)

        // Act, Assert
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculatorService.execute(expression)
            }
    }
}
