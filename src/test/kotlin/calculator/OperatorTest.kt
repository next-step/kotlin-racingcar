package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperatorTest {
    @Test()
    fun `symbol과 일치하는 연산자 enum을 반환한다`() {
        val expectedSymbol = "+"

        val result = Operator.findBy(expectedSymbol)

        assertThat(result).isEqualTo(Operator.PLUS)
    }

    @Test()
    fun `source와 target을 더한 값이 반환된다`() {
        assertThat(Operator.PLUS.evaluate(1, 2)).isEqualTo(3)
    }

    @Test()
    fun `source에서 target을 뺀 값이 반환된다`() {
        assertThat(Operator.MINUS.evaluate(3, 2)).isEqualTo(1)
    }

    @Test()
    fun `source와 target을 곱한 값이 반환된다`() {
        assertThat(Operator.MULTIPLY.evaluate(4, 3)).isEqualTo(12)
    }

    @Test()
    fun `source에서 target을 나눈 값이 반환된다`() {
        assertThat(Operator.DIVIDE.evaluate(6, 3)).isEqualTo(2)
    }

    @Test()
    fun `0으로 나누려고 할 경우 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Operator.DIVIDE.evaluate(1, 0)
        }
    }
}
