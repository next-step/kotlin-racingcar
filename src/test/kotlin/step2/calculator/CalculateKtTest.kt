package step2.calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("계산을 담당하는 calculate 함수 테스트")
internal class CalculateKtTest {
    @DisplayName("주어진 문자열 수식이 올바른 경우 계산값 반환 테스트")
    @ParameterizedTest
    @MethodSource("validStringExpression")
    fun validStringExpressionTest(stringExpression: String, expectedValue: Int) {
        // Arrange
        // Act
        val result = calculate(stringExpression)

        // Assert
        Assertions.assertThat(result).isEqualTo(expectedValue)
    }

    @DisplayName("주어진 문자열 수식이 올바르지 않은 경우 계산값 반환 테스트")
    @ParameterizedTest
    @MethodSource("invalidStringExpression")
    fun invalidStringExpressionTest(
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
        fun validStringExpression(): Stream<Arguments> {
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
        fun invalidStringExpression(): Stream<Arguments> {
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
