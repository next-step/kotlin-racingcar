package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    @Test
    fun `입력값이 Null이라면 IllegalArgumentException이 발생합니다`() {
        val input: String? = null

        val stringCalculator: StringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 빈 문자열이라면 IllegalArgumentException이 발생합니다`() {
        val input: String = ""

        val stringCalculator: StringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 공백이라면 IllegalArgumentException이 발생합니다`() {
        val input: String = " "

        val stringCalculator: StringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 숫자 하나라면 해당 숫자를 반환합니다`() {
        val input: String = "1"

        val stringCalculator: StringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(1)
    }

    @Test
    fun `처음 입력값이 숫자가 아니라면 IllegalArgumentException이 발생합니다`() {
        val input: String = "+ 1"

        val stringCalculator: StringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 숫자 두개와 덧셈 기호라면 두 숫자를 더한 값을 반환합니다`() {
        val input: String = "1 + 2"

        val stringCalculator: StringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(3)
    }
}
