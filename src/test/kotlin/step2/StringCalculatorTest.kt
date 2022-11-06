package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = ["1 + 2,3", "10 - 2,8", "5 * 2,10", "10 / 2,5", "2 + 3 * 4 / 2,10"])
    fun `올바른 수식을 입력한 경우`(input: String?, expected: Int?) {
        val stringCalculator = StringCalculator()

        assertThat(stringCalculator.calculate(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 null 또는 빈 문자열인 경우`(input: String?) {
        val stringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `사칙 연산 기호가 아닌 경우`() {
        val input = "2 ? 3 * 4 / 2"
        val stringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }
}
