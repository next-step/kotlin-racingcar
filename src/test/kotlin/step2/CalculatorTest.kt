package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import step2.tasks.Calculator
import step2.util.Const.Companion.DELIMITERS_BLANK
import step2.util.Const.Companion.NOTICE_NOT_BLANK
import step2.util.extension.splitToCalculate

class CalculatorTest {

    @Test
    @DisplayName("Given 'Calculator', When '10 / 2 * 3 - 1' , Then '14'")
    fun `올바른 연산`() {
        val calculator = Calculator()
        val input = "10 / 2 * 3 - 1".splitToCalculate(DELIMITERS_BLANK)

        assertThat(calculator.calculate(input))
            .isEqualTo("14.0")
    }

    @Test
    @DisplayName("Given 'DELIMITERS_BLANK', When 'Split DELIMITERS_BLANK' Then 'NOTICE_NOT_BLANK'")
    fun `split 공백문자`() {
        assertThatThrownBy { DELIMITERS_BLANK.splitToCalculate(DELIMITERS_BLANK) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NOTICE_NOT_BLANK)
    }
}
