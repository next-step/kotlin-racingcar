package expressioncalculator.calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @Test
    fun `Operator의 symbol이 정확한지 확인한다`() {
        assertAll(
            { assertThat(Operator.SYMBOL_PLUS).isEqualTo(Operator.PLUS.symbol) },
            { assertThat(Operator.SYMBOL_MINUS).isEqualTo(Operator.MINUS.symbol) },
            { assertThat(Operator.SYMBOL_MULTIPLY).isEqualTo(Operator.MULTIPLY.symbol) },
            { assertThat(Operator.SYMBOL_DIVIDE).isEqualTo(Operator.DIVIDE.symbol) }
        )
    }

    @Test
    fun `PLUS Operator의 operate를 통해 두 수를 더할 수 있다`() {
        val result = Operator.PLUS.operate(1.0, 10.0)

        assertThat(result).isEqualTo(11.0)
    }

    @Test
    fun `MINUS Operator의 operate를 통해 두 수를 뺄 수 있다`() {
        val result = Operator.MINUS.operate(10.0, 5.0)

        assertThat(result).isEqualTo(5.0)
    }

    @Test
    fun `MULTIPLY Operator의 operate를 통해 두 수를 곱할 수 있다`() {
        val result = Operator.MULTIPLY.operate(2.0, 10.0)

        assertThat(result).isEqualTo(20.0)
    }

    @Test
    fun `DIVIDE Operator의 operate를 통해 두 수를 나눌 수 있다`() {
        val result = Operator.DIVIDE.operate(10.0, 2.0)

        assertThat(result).isEqualTo(5.0)
    }

    @Test
    fun `DIVIDE Operator의 operate에서 0으로 나누기를 시도하면 IllegalArgumentException이 발생한다`() {
        Assertions.assertThatThrownBy {
            Operator.DIVIDE.operate(10.0, 0.0)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙 연산 기호를 전달받아 적절한 Operator를 반환한다`() {
        val plus = Operator.from(Operator.SYMBOL_PLUS)
        val minus = Operator.from(Operator.SYMBOL_MINUS)
        val multiply = Operator.from(Operator.SYMBOL_MULTIPLY)
        val divide = Operator.from(Operator.SYMBOL_DIVIDE)

        assertAll(
            { assertThat(plus).isEqualTo(Operator.PLUS) },
            { assertThat(minus).isEqualTo(Operator.MINUS) },
            { assertThat(multiply).isEqualTo(Operator.MULTIPLY) },
            { assertThat(divide).isEqualTo(Operator.DIVIDE) }
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["?", "$"])
    fun `사칙 연산 기호가 아닌 값이 팩토리 메서드에 전달되면 에러를 던진다`(symbol: String) {
        Assertions.assertThatThrownBy {
            Operator.from(symbol)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
