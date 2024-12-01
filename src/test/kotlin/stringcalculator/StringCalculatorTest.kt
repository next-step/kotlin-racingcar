package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "2", "+",
            "1+ 1", "1 +1", "1     + 1",
            "a + b", "1 + !", "딱 + 9",
            "1 ++ 1", "1 -+ 1", "1 | 1", "1 % 1", "1 ! 1", "1 -- 1", "1 *+ 1", "1 + 1 +",
        ],
    )
    @NullAndEmptySource
    fun `{숫자 연산자 숫자} 형태의 입력이 아닐 경우 예외를 발생시킨다`(input: String?) {
        val stringCalculator = StringCalculator()

        assertThatThrownBy { stringCalculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, 10",
        "2 + 3 * 4 / 2, 10",
        "2 + 3 - 3 * 4 / 2, 4",
        "1 + 1, 2",
    )
    fun `입력된 문자열값에 따라 사칙 연산을 수행한다`(
        input: String?,
        expected: Int,
    ) {
        val stringCalculator = StringCalculator()

        val actual = stringCalculator.calculate(input)

        assertThat(actual).isEqualTo(expected)
    }
}
