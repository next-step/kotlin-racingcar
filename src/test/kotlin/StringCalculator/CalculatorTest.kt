package StringCalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `유효하지 못한 입력`() {
        // null
        assertThatThrownBy {
            Calculator.calculate(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
        // empty string
        assertThatThrownBy {
            Calculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // white space
        assertThatThrownBy {
            Calculator.calculate("   ")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 잘못된 기호
        assertThatThrownBy {
            Calculator.calculate(" &  ")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 연산 기호 하나만 있음
        assertThatThrownBy {
            Calculator.calculate("+")
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 숫자의 연속
        assertThatThrownBy {
            Calculator.calculate("123 12")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `유효한 입력`() {
        assertThat(Calculator.calculate("123")).isEqualTo(123)
        assertThat(Calculator.calculate("+123")).isEqualTo(123)
        assertThat(Calculator.calculate("-123")).isEqualTo(-123)
        assertThat(Calculator.calculate("123 + 12")).isEqualTo(135)
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @Test
    fun `덧셈`() {
        assertThat(CalculatorOperator.ADD.calculate(3, 2)).isEqualTo(5)
    }

    @Test
    fun `뺄셈`() {
        assertThat(CalculatorOperator.SUBTRACT.calculate(3, 2)).isEqualTo(1)
    }

    @Test
    fun `곱셈`() {
        assertThat(CalculatorOperator.MULTIPLY.calculate(3, 2)).isEqualTo(6)
    }

    @Test
    fun `나눗셈`() {
        assertThat(CalculatorOperator.DIVIDE.calculate(3, 2)).isEqualTo(1)
    }
}
