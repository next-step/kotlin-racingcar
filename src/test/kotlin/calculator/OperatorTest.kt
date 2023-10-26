@file:Suppress("NonAsciiCharacters")

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `fromSymbol - 주어진 symbol을 가진 Operator를 반환한다`() {
        val symbol = "+"

        val result = Operator.fromSymbol(symbol)

        assertThat(result).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `fromSymbol - 주어진 symbol을 가진 Operator가 존재하지 않으면 NoSuchElementException을 던진다`() {
        val symbol = "%"

        val result = catchThrowable {
            Operator.fromSymbol(symbol)
        }

        assertThat(result).isInstanceOf(NoSuchElementException::class.java)
            .hasMessageContaining("There is no Operator with symbol")
    }

    @Test
    fun `getFourBasicOperators - 사칙연산자 set을 반환한다`() {
        val result = Operator.getFourBasicOperators()

        assertThat(result).containsExactly(
            Operator.PLUS,
            Operator.MINUS,
            Operator.MULTIPLY,
            Operator.DIVIDE,
        )
    }
}
