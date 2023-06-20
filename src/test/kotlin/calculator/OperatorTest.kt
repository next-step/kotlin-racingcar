package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class OperatorTest {

    @ParameterizedTest(name = "{0} {1} {2} = {3}")
    @CsvSource(value = ["1, +, 2, 3", "1, -, 2, -1", "3, *, 4, 12", "4, /, 2, 2", "5, /, 2, 2.5"])
    fun apply(left: BigDecimal, symbol: String, right: BigDecimal, expected: BigDecimal) {
        val operator = Operator.from(symbol)

        val result = operator.apply(left, right)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `사칙연산이 아닌경우 예외가 발생한다`() {
        assertThatThrownBy { Operator.from("&") }
            .isInstanceOf(InvalidSymbolException::class.java)
    }

    @Test
    fun `0으로 나누면 예외가 발생한다`() {
        assertThatThrownBy { Operator.DIVIDE.apply(BigDecimal(1), BigDecimal(0)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
