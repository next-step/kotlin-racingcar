package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test()
    fun `findBy 메서드는 전달받은 symbol과 일치하는 연산자 enum을 반환한다`() {
        val expectedSymbol = "+"

        val result = Operator.findBy(expectedSymbol)

        assertThat(result.symbol).isEqualTo(expectedSymbol)
    }

    @Test()
    fun `PLUS는 source와 target을 더한 값이 반환된다`() {
        assertThat(Operator.PLUS.evaluate(1, 2)).isEqualTo(3)
    }

    @Test()
    fun `MINUS는 source에서 target을 뺀 값이 반환된다`() {
        assertThat(Operator.MINUS.evaluate(3, 2)).isEqualTo(1)
    }

    @Test()
    fun `MULTIPLY는 source와 target을 곱한 값이 반환된다`() {
        assertThat(Operator.MULTIPLY.evaluate(4, 3)).isEqualTo(12)
    }

    @Test()
    fun `DIVIDE는 source에서 target을 나눈 값이 반환된다`() {
        assertThat(Operator.DIVIDE.evaluate(6, 3)).isEqualTo(2)
    }
}
