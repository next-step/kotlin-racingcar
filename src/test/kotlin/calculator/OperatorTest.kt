package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.ThrowableAssert.ThrowingCallable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class OperatorTest {

    @Test
    fun `옳바른 기호가 아니면 예외를 발생한다`() {
        // given
        val throwingCallable = ThrowingCallable {
            Operator.of("(")
        }
        // then
        assertThatIllegalArgumentException().isThrownBy(throwingCallable).withMessage("invalid operator")
    }

    @ParameterizedTest
    @MethodSource("operators")
    fun `해당 기호에 대한 연산자를 반환한다`(sign: String, operator: Operator) {
        // given
        val actual = Operator.of(sign)
        // then
        assertThat(actual).isEqualTo(operator)
    }

    @Test
    fun `더하기 연산자는 두개의 피연산자를 더한 값을 반환한다`() {
        // given
        val plusOperator = Operator.PLUS
        // when
        val actual = plusOperator.calculate(1, 2)
        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `빼기 연산자는 두개의 피연산자를 뺀 값을 반환한다`() {
        // given
        val plusOperator = Operator.MINUS
        // when
        val actual = plusOperator.calculate(2, 1)
        // then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `곱하기 연산자는 두개의 피연산자를 곱한 값을 반환한다`() {
        // given
        val plusOperator = Operator.MULTIPLY
        // when
        val actual = plusOperator.calculate(2, 2)
        // then
        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun `나누기 연산자는 두개의 피연산자를 나눈 값을 반환한다`() {
        // given
        val plusOperator = Operator.DIVIDE
        // when
        val actual = plusOperator.calculate(2, 2)
        // then
        assertThat(actual).isEqualTo(1)
    }

    companion object {
        @JvmStatic
        fun operators() = listOf(
            Arguments.of("+", Operator.PLUS),
            Arguments.of("-", Operator.MINUS),
            Arguments.of("*", Operator.MULTIPLY),
            Arguments.of("/", Operator.DIVIDE)
        )
    }
}
