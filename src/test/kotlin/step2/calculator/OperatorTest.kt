package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `연산자 찾기 테스트`() {
        val plus = "+"
        val minus = "-"
        val multiply = "*"
        val divide = "/"
        val shap = "#"

        assertThat(Operator.findOperator(plus)).isEqualTo(Operator.PLUS)
        assertThat(Operator.findOperator(minus)).isEqualTo(Operator.MINUS)
        assertThat(Operator.findOperator(multiply)).isEqualTo(Operator.MULTIPLY)
        assertThat(Operator.findOperator(divide)).isEqualTo(Operator.DIVIDED)
        assertThatThrownBy { Operator.findOperator(shap) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
