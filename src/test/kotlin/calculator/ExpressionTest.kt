package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {
    @Test
    fun `수식에 포함된 연산자, 피연산자의 개수가 짝수면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            Expression("1 * 2 3")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `수식에 정의되지 않은 연산자가 포함되면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            Expression("1 * 2 ^ 3")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `수식에 숫자와 연산자가 아닌 다른 문자열이 포함되면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            Expression("1 * a")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+ 2 + 3", "2 + 3 *"])
    fun `수식이 연산자로 시작하거나 끝나면 예외가 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            Expression(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `수식에 연산자가 연속으로 있을 경우 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            Expression("2 + - 3")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `수식의 값을 계산한다`() {
        assertThat(Expression("1 + 3 * 3 / 2").evaluate()).isEqualTo(6)
        assertThat(Expression("100 / 2 - 11 + 3").evaluate()).isEqualTo(42)
    }
}
