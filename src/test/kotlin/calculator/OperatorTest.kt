package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `사칙연산`() {
        assertThat(Operator.valueOfSign("+")).isEqualTo(Operator.PLUS)
        assertThat(Operator.valueOfSign("-")).isEqualTo(Operator.MINUS)
        assertThat(Operator.valueOfSign("*")).isEqualTo(Operator.MULTIPLY)
        assertThat(Operator.valueOfSign("/")).isEqualTo(Operator.DIVIDE)
        assertThatThrownBy { Operator.valueOfSign("&") }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
