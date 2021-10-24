package step2.calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("문자열 수식을 계산 가능한 수식(MathExpression)으로 변경하는 함수 테스트")
internal class ParseToMathExpressionKtTest {
    @DisplayName("주어진 문자열 수식이 비어있는 경우 예외 테스트")
    @ParameterizedTest
    @MethodSource("blankStringExpression")
    fun blankStringExpressionTest(
        stringExpression: String,
        expectedException: Exception,
    ) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            parseToMathExpression(stringExpression)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(stringExpression)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun blankStringExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("", illegalArgumentException),
                Arguments.of("  ", illegalArgumentException),
                Arguments.of("                          ", illegalArgumentException),
            )
        }
    }
}
