package calculator

import calculator.Operate.Companion.signCheck
import calculator.StringCalculator.Companion.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {
    @Test
    fun `입력 값이 null 또는 빈 문자열`() {
        assertThatThrownBy { calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate(" ") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        assertThat(signCheck("+"))
        assertThat(signCheck("-"))
        assertThat(signCheck("*"))
        assertThat(signCheck("/"))
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, 10",
        "4 + 1 * 2 / 5, 2",
        "6 - 1 * 8 / 2, 20"
    )
    fun `연산`(numericalString: String, result: Int) {
        Assertions.assertEquals(calculate(numericalString), result)
    }
}
