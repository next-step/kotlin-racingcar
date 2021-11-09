package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import calculator.Calculator.calculate
import java.util.stream.Stream

@DisplayName("계산을 담당하는 함수인 calculate 테스트")
internal class CalculatorTest {
    @DisplayName("주어진 문자열 수식이 올바른 경우 수식 계산 시 올바른 값 반환")
    @ParameterizedTest
    @MethodSource("correctStringExpression")
    fun given_CorrectStringExpression_when_Calculate_then_ReturnCorrectResult(
        stringExpression: String,
        expectedValue: Int
    ) {
        // Arrange
        // Act
        val result = calculate(stringExpression)

        // Assert
        Assertions.assertThat(result).isEqualTo(expectedValue)
    }

    @DisplayName("주어진 문자열 수식이 올바르지 않은 경우 수식 계산 시 ArithmeticException 예외 발생")
    @ParameterizedTest
    @MethodSource("incorrectStringExpression")
    fun given_IncorrectStringExpression_when_Calculate_then_ThrowArithmeticException(
        stringExpression: String,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            calculate(stringExpression)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessages)
    }

    companion object {
        private const val arithmeticExceptionErrorMessage = "Error occurred during calculate"
        private const val invalidExpressionErrorMessage = " is not valid expression"
        private val arithmeticException = ArithmeticException()
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun correctStringExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 2", 3),
                Arguments.of("1 + 2 + 3 + 4 + 5", 15),
                Arguments.of("7 * 2 * 3 - 2 / 4", 10),
                Arguments.of("7 * 2 * 3 - 2 / 4", 10),
                Arguments.of("777 * 2 + 6 - 560 / 4", 250),
                Arguments.of("111111 * 10 * 3 * 5 - 666000", 16_000_650),
            )
        }

        @JvmStatic
        fun incorrectStringExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("2 / 0", arithmeticException, arithmeticExceptionErrorMessage),
                Arguments.of("1 + 2 3", illegalArgumentException, invalidExpressionErrorMessage),
                Arguments.of("15", illegalArgumentException, invalidExpressionErrorMessage),
                Arguments.of("7   4", illegalArgumentException, invalidExpressionErrorMessage),
                Arguments.of("7 * 2 * 3 -", illegalArgumentException, invalidExpressionErrorMessage),
                Arguments.of("/ 4", illegalArgumentException, invalidExpressionErrorMessage),
                Arguments.of("", illegalArgumentException, invalidExpressionErrorMessage),
                Arguments.of("                  ", illegalArgumentException, invalidExpressionErrorMessage),
                Arguments.of("2 / 0", arithmeticException, arithmeticExceptionErrorMessage),
            )
        }
    }
}
