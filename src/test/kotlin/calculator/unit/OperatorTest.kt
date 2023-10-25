package calculator.unit

import calculator.Operator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `플러스 연산자를 가져온다`() {
        val operator = Operator.from("+")
        assertThat(operator).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `마이너스 연산자를 가져온다`() {
        val operator = Operator.from("-")
        assertThat(operator).isEqualTo(Operator.MINUS)
    }

    @Test
    fun `곱하기 연산자를 가져온다`() {
        val operator = Operator.from("*")
        assertThat(operator).isEqualTo(Operator.MULTIPLY)
    }

    @Test
    fun `나누기 연산자를 가져온다`() {
        val operator = Operator.from("/")
        assertThat(operator).isEqualTo(Operator.DIVIDE)
    }

    @Test
    fun `덧셈에 성공한다`() {
        val operator = Operator.PLUS
        val result = operator.calculate(1, 2)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `뺄셈에 성공한다`() {
        val operator = Operator.MINUS
        val result = operator.calculate(1, 2)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `곱셈에 성공한다`() {
        val operator = Operator.MULTIPLY
        val result = operator.calculate(1, 2)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `나눗셈에 성공한다`() {
        val operator = Operator.DIVIDE
        val result = operator.calculate(2, 2)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `나눗셈의 소수점은 버려진다`() {
        val operator = Operator.DIVIDE
        val result = operator.calculate(3, 2)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `알 수 없는 연산자가 들어오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Operator.from("^")
        }
    }
}
