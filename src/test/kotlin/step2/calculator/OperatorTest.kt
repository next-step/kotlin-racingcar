package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `Operator의 symbol이 정확한지 확인한다`() {
        val plus = "+"
        val minus = "-"
        val multiply = "*"
        val divide = "/"

        assertThat(plus).isEqualTo(Operator.PLUS.symbol)
        assertThat(minus).isEqualTo(Operator.MINUS.symbol)
        assertThat(multiply).isEqualTo(Operator.MULTIPLY.symbol)
        assertThat(divide).isEqualTo(Operator.DIVIDE.symbol)
    }
}