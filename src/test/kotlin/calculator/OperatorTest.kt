package calculator

import calculator.Operator.Companion.valueOfSign
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `사칙연산 기호`() {
        assertThat(valueOfSign("+")).isEqualTo(Operator.PLUS)
        assertThat(valueOfSign("-")).isEqualTo(Operator.MINUS)
        assertThat(valueOfSign("*")).isEqualTo(Operator.MULTIPLY)
        assertThat(valueOfSign("/")).isEqualTo(Operator.DIVIDE)
        assertThatThrownBy { valueOfSign("&") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산`() {
        assertThat(valueOfSign("+").operation(3, 4)).isEqualTo(7)
        assertThat(valueOfSign("-").operation(2, 1)).isEqualTo(1)
        assertThat(valueOfSign("*").operation(3, 4)).isEqualTo(12)
        assertThat(valueOfSign("/").operation(6, 3)).isEqualTo(2)
    }
}
