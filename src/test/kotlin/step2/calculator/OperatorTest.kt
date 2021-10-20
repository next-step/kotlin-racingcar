package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import step2.calculator.Operator.Companion.INVALID_OPERATOR_ERROR_MESSAGE
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("계산을 담당하는 Operator 테스트")
internal class OperatorTest {
    @DisplayName("주어진 연산자가 올바른 경우 연산자 매핑 테스트")
    @ParameterizedTest
    @MethodSource("validOperator")
    fun getOperatorWhenGivenValidOperator(givenOperator: String, expectedOperator: Operator) {
        assertThat(Operator.getOperator(givenOperator)).isEqualTo(expectedOperator)
    }

    @DisplayName("주어진 연산자가 올바르지 않은 경우 연산자 매핑 테스트")
    @ParameterizedTest
    @MethodSource("invalidOperator")
    fun getOperatorWhenGivenInvalidOperator(givenOperator: String, expectedException: Exception) {
        assertThatThrownBy() {
            Operator.getOperator(givenOperator)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(INVALID_OPERATOR_ERROR_MESSAGE)
    }

    companion object {
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun validOperator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("+", Operator.ADDITION),
                Arguments.of("-", Operator.SUBTRACTION),
                Arguments.of("*", Operator.MULTIPLICATION),
                Arguments.of("/", Operator.DIVISION)
            )
        }

        @JvmStatic
        fun invalidOperator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("!", illegalArgumentException),
                Arguments.of("@", illegalArgumentException),
                Arguments.of("#", illegalArgumentException),
                Arguments.of("$", illegalArgumentException),
                Arguments.of("%", illegalArgumentException),
                Arguments.of("^", illegalArgumentException),
                Arguments.of("&", illegalArgumentException),
                Arguments.of("(", illegalArgumentException),
                Arguments.of(")", illegalArgumentException),
                Arguments.of("_", illegalArgumentException),
                Arguments.of(".", illegalArgumentException),
                Arguments.of("?", illegalArgumentException),
                Arguments.of("0", illegalArgumentException),
                Arguments.of("1", illegalArgumentException),
            )
        }
    }
}
