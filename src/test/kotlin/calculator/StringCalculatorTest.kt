package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = ["1 + 2 = 3", "3 - 1 = 2", "2 * 2 = 4", "6 / 2 = 3", "1 + 2 * 2 = 6", "2 + 3 * 4 / 2 = 10"],
        delimiter = '='
    )
    fun `계산 성공`(input: String, answer: Int) {
        val result: Int = calculateFromString(input)
        assertThat(result).isEqualTo(answer)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력 값이 null 이거나 공백문자일 경우 에러`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { calculateFromString(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 . 1", "1 1 1", "1 1"])
    fun `사칙연산 기호가 아닌 경우 에러`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { calculateFromString(input) }
    }
}
