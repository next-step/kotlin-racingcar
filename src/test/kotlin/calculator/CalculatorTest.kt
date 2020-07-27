package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {
    private var calculator = Calculator()

    @Test
    fun `when enter the correct value then return the correct result`() {
        val result = calculator.calculate("2 + 3 * 4 / 2")
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `when the argument is empty space then throw illegalArgument exception`() {
        assertThatThrownBy { calculator.calculate(" ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("공백 문자는 입력할 수 없습니다.")
    }

    @Test
    fun `when the operator is not arithmetic operator then throw illegalArgument exception`() {
        assertThatThrownBy { calculator.calculate("1 & 5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("사칙연산 부호가 아닙니다.")
    }

    @Test
    fun `when the number type is not int then throw not supported type exception`() {
        assertThatThrownBy { calculator.calculate("1.3 + 2.4") }
            .isInstanceOf(NotSupportedTypeException::class.java)
            .hasMessage("정수만 입력할 수 있습니다.")
    }
}
