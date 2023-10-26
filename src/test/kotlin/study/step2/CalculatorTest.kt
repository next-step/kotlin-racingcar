package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun `덧셈`() {
        val input = "1 + 2"
        val expected = 3.0
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `뺄셈`() {
        val input = "2 - 1"
        val expected = 1.0
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `곱셈`() {
        val input = "2 * 3"
        val expected = 6.0
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `나눗셈`() {
        val input = "6 / 3"
        val expected = 2.0
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `실수 테스트`() {
        val input = "5 + 2 / 2"
        val exppected = 3.5
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(exppected)
    }

    @Test
    fun `나눗셈_예외 테스트`() {
        val input = "6 / 0"
        assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로 나눌 수 없습니다.")
    }

    @Test
    fun `복잡한 연산 테스트`() {
        val input = "2 + 3 * 4 / 2"
        val expected = 10.0
        val acutal = calculator.calculate(input)
        assertThat(acutal).isEqualTo(expected)
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
