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

        assertThat(Operator.getOperator(test1)).isEqualTo(Operator.PLUS)
        assertThat(Operator.getOperator(test2)).isEqualTo(Operator.MINUS)
        assertThat(Operator.getOperator(test3)).isEqualTo(Operator.MULTIPLY)
        assertThat(Operator.getOperator(test4)).isEqualTo(Operator.DIVIDED)
        assertThatThrownBy { Operator.getOperator(test5) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}