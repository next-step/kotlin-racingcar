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

    @Test
    fun `isFourBasicOperations - 주어진 기호가 사칙연산이면 true를 반환한다`() {
        val symbol = "+"

        val result = Operator.isFourBasicOperations(symbol)

        assertThat(result).isTrue()
    }

    @Test
    fun `isFourBasicOperations - 주어진 기호가 사칙연산이 아니면 false를 반환한다`() {
        val symbol = "%"

        val result = Operator.isFourBasicOperations(symbol)

        assertThat(result).isFalse()
    }

    @Test
    fun `operate - PLUS의 경우 두 값을 더한 값을 반환한다`() {
        val operand1 = 1.0
        val operand2 = 2.0

        val result = Operator.PLUS.operate(operand1, operand2)

        assertThat(result).isEqualTo(3.0)
    }

    @Test
    fun `operate - MINUS의 경우 두 값을 뺀 값을 반환한다`() {
        val operand1 = 2.0
        val operand2 = 1.0

        val result = Operator.MINUS.operate(operand1, operand2)

        assertThat(result).isEqualTo(1.0)
    }

    @Test
    fun `operate - MULTIPLY의 경우 두 값을 더한 값을 반환한다`() {
        val operand1 = 2.0
        val operand2 = 3.0

        val result = Operator.MULTIPLY.operate(operand1, operand2)

        assertThat(result).isEqualTo(6.0)
    }

    @Test
    fun `operate - DIVIDE의 경우 두 값을 더한 값을 반환한다`() {
        val operand1 = 3.0
        val operand2 = 2.0

        val result = Operator.DIVIDE.operate(operand1, operand2)

        assertThat(result).isEqualTo(1.5)
    }

    @Test
    fun `operate - DIVIDE의 경우 0으로 나누면 ArithmeticException을 던진다`() {
        val operand1 = 1.0
        val operand2 = 0.0

        val result = catchThrowable {
            Operator.DIVIDE.operate(operand1, operand2)
        }

        assertThat(result).isInstanceOf(ArithmeticException::class.java)
            .hasMessageContaining("Division by zero.")
    }
}
