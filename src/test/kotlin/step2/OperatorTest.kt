package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.ThrowableAssert.ThrowingCallable
import org.junit.jupiter.api.Test

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

    @Test
    fun `기호가 더하기면 더하기 연산자를 반환한다`() {
        // given
        val actual = Operator.of("+")
        // then
        assertThat(actual).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `기호가 빼기면 빼기 연산자를 반환한다`() {
        // given
        val actual = Operator.of("-")
        // then
        assertThat(actual).isEqualTo(Operator.MINUS)
    }

    @Test
    fun `기호가 곱하기면 곱하기 연산자를 반환한다`() {
        // given
        val actual = Operator.of("*")
        // then
        assertThat(actual).isEqualTo(Operator.MULTIPLY)
    }

    @Test
    fun `기호가 나누기면 나누기 연산자를 반환한다`() {
        // given
        val actual = Operator.of("/")
        // then
        assertThat(actual).isEqualTo(Operator.DIVIDE)
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
}
