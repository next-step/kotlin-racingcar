package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `연산자 찾기 테스트`() {
        val test1 = "+"
        val test2 = "-"
        val test3 = "*"
        val test4 = "/"
        val test5 = "#"

        assertThat(Operator.findOperator(test1)).isEqualTo(Operator.PLUS)
        assertThat(Operator.findOperator(test2)).isEqualTo(Operator.MINUS)
        assertThat(Operator.findOperator(test3)).isEqualTo(Operator.MULTIPLY)
        assertThat(Operator.findOperator(test4)).isEqualTo(Operator.DIVIDED)
        assertThatThrownBy { Operator.findOperator(test5) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
