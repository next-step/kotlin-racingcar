package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class OperatorTest {

    private val num1 = Number.of("6")
    private val num2 = Number.of("3")

    @Test
    fun `사칙연산 기호가 아닌 것을 넣으면 예외를 반환한다`() {
        assertThatThrownBy {
            Operator.of("=")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("the value not Operator")
    }

    @Test
    fun `PLUS 의 operation 을 실행하면 9 를 반환한다`() {
        val result = Operator.PLUS.operation(num1, num2)
        assertThat(result).isEqualTo(Number.of("9"))
    }

    @Test
    fun `MINUS 의 operation 을 실행하면 3 을 반환한다`() {
        val result = Operator.MINUS.operation(num1, num2)
        assertThat(result).isEqualTo(Number.of("3"))
    }

    @Test
    fun `TIMES 의 operation 을 실행하면 18 을 반환한다`() {
        val result = Operator.TIMES.operation(num1, num2)
        assertThat(result).isEqualTo(Number.of("18"))
    }

    @Test
    fun `DIVIDE 의 operation 을 실행하면 2 를 반환한다`() {
        val result = Operator.DIVIDE.operation(num1, num2)
        assertThat(result).isEqualTo(Number.of("2"))
    }
}
