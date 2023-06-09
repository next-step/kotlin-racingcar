package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {

    @ParameterizedTest(name = "{0} {1} {2} = {3}")
    @CsvSource(value = ["1, +, 2, 3", "1, -, 2, -1", "3, *, 4, 12", "4, /, 2, 2"])
    fun apply(left: Int, symbol: String, right: Int, expected: Int) {
        val operator = Operator.from(symbol)
        assertThat(operator.apply(left, right)).isEqualTo(expected)
    }

    @Test
    fun `사칙연산이 아닌경우 예외가 발생한다`() {
        assertThatThrownBy { Operator.from("&") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `0으로 나누면 예외가 발생한다`() {
        assertThatThrownBy { Operator.DIVIDE.apply(1, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
