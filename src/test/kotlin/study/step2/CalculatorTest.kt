package study.step2

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun `덧셈`() {
        val calculator = Calculator()
        val actual = calculator.add(1, 2)
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        val calculator = Calculator()
        val actual = calculator.subtract(2, 1)
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `곱셈`() {
        val calculator = Calculator()
        val actual = calculator.multiply(2, 3)
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `나눗셈`() {
        val calculator = Calculator()
        val actual = calculator.divide(6, 3)
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `나눗셈_예외`() {
        val calculator = Calculator()
        assertThatThrownBy { calculator.divide(6, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로 나눌 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `공백 문자열 예외 테스트`(input: String) {
        assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 비어있습니다.")
    }

    @Test
    fun `올바르지 않은 입력값 예외 테스트`() {
        val input = "a + 2"
        assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("올바르지 않는 입력값입니다.")
    }

    @Test
    fun `올바르지 않은 연산자 예외 테스트`() {
        val input = "1 $#@$) 2"
        assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산자는 +, -, *, / 중 하나여야 합니다.")
    }
}
