package calculator

import calculator.StringCalculator.Companion.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = [" ", "  ", "   "])
    fun `입력값 공백, 널 검증`(input: String?) {
        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "2 + + 3",
            "- 5 + 2",
            "1 1 2",
            "1 $ 2"
        ]
    )
    fun `계산할수 없는 입력값 검증`(input: String) {
        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2:10",
            "5 * 10 / 5 / 2:5",
            "7 / 2 * 100 - 1:299"
        ], delimiter = ':'
    )
    fun `문자열 사칙연산`(input: String, expected: Int) {
        assertThat(calculate(input)).isEqualTo(expected)
    }
}
