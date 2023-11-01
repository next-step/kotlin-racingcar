package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringCalculatorTest {

    private val stringCalculator: StringCalculator = StringCalculator()

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 Null 또는 Empty 값이라면 IllegalArgumentException이 발생합니다`(input: String?) {
        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @CsvSource("1, 1", "2, 2", "3, 3")
    fun `입력값이 숫자 하나라면 해당 숫자를 반환합니다`(input: String, expected: Long) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("+ 1", "- 1", "* 1", "/ 1", "a 1")
    fun `처음 입력값이 숫자가 아니라면 IllegalArgumentException이 발생합니다`(input: String) {
        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @ParameterizedTest
    @CsvSource("1 + 2, 3", "2 + 2, 4", "3 + 2, 5")
    fun `입력값이 숫자 두개와 덧셈 기호라면 두 숫자를 더한 값을 반환합니다`(input: String, expected: Long) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1 + 2 * 3 / 3, 3", "1 + 2 - 3, 0", "1 + 2 * 3 - 4, 5")
    fun `입력값에 계산식이 여러개라면 모든 계산식을 계산한 결과를 반환합니다`(input: String, expected: Long) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected)
    }
}
