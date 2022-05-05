package step2.calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `Operator의 symbol이 정확한지 확인한다`() {
        assertThat(PLUS).isEqualTo(Operator.PLUS.symbol)
        assertThat(MINUS).isEqualTo(Operator.MINUS.symbol)
        assertThat(MULTIPLY).isEqualTo(Operator.MULTIPLY.symbol)
        assertThat(DIVIDE).isEqualTo(Operator.DIVIDE.symbol)
    }

    @Test
    fun `PLUS Operator의 operate를 통해 두 수를 더할 수 있다`() {
        val result = Operator.PLUS.operate(1.0, 10.0)

        assertThat(result).isEqualTo(1.0 + 10.0)
    }

    @Test
    fun `MINUS Operator의 operate를 통해 두 수를 뺄 수 있다`() {
        val result = Operator.MINUS.operate(10.0, 5.0)

        assertThat(result).isEqualTo(10.0 - 5.0)
    }

    @Test
    fun `MULTIPLY Operator의 operate를 통해 두 수를 곱할 수 있다`() {
        val result = Operator.MULTIPLY.operate(2.0, 10.0)

        assertThat(result).isEqualTo(2.0 * 10.0)
    }

    @Test
    fun `DIVIDE Operator의 operate를 통해 두 수를 나눌 수 있다`() {
        val result = Operator.DIVIDE.operate(10.0, 2.0)

        assertThat(result).isEqualTo(10.0 / 2.0)
    }

    @Test
    fun `사칙 연산 기호를 전달받아 적절한 Operator를 반환한다`() {
        val plus = Operator.from(PLUS)
        val minus = Operator.from(MINUS)
        val multiply = Operator.from(MULTIPLY)
        val divide = Operator.from(DIVIDE)

        assertThat(plus).isEqualTo(Operator.PLUS)
        assertThat(minus).isEqualTo(Operator.MINUS)
        assertThat(multiply).isEqualTo(Operator.MULTIPLY)
        assertThat(divide).isEqualTo(Operator.DIVIDE)
    }

    @Test
    fun `사칙 연산 기호가 아닌 값이 팩토리 메서드에 전달되면 에러를 던진다`() {
        Assertions.assertThatThrownBy {
            Operator.from("?")
        }.isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy {
            Operator.from("$")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        private const val PLUS = "+"
        private const val MINUS = "-"
        private const val MULTIPLY = "*"
        private const val DIVIDE = "/"
    }
}