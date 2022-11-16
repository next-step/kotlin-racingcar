package calculator

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @Test
    fun `덧셈`() {
        val input = "2 + 3"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(Num(5))
    }

    @Test
    fun `뺄셈`() {

        val input = "3 - 2"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(Num(1))
    }

    @Test
    fun `곱셈`() {

        val input = "2 * 4"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(Num(8))
    }

    @Test
    fun `나눗셈`() {

        val input = "4 / 2"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(Num(2))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 null 이거나 빈 공백문자 일경우`(input: String) {

        val stringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 ! 3 * 4 / 2", "23 * 22A * 1"])
    fun `사칙연산 기호가 아닌경우`(mathematical: String) {

        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(mathematical)
        }
    }

    @Test
    fun `사칙연산을 실행한다`() {

        val mathematical = "2 + 3 * 4 / 2"
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(mathematical)

        assertThat(result).isEqualTo(Num(10))
    }
}
