package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorInputValueTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `빈 문자열 입력`(inputValue: String) {
        assertThrows<IllegalArgumentException> {
            CalculatorInputValue(inputValue)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 / 3 ( ㅁ", "ㅂ @ + 3"])
    fun `사칙연산 또는 숫자가 아닌 값이 들어왔을때`(inputValue: String) {
        assertThrows<IllegalArgumentException> {
            CalculatorInputValue(inputValue)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 / 3 * 3", "4 - 2 * 5 / 2"])
    fun `그린 케이스`(inputValue: String) {
        val actual = CalculatorInputValue(inputValue)
        assertThat(actual.value).isEqualTo(inputValue)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + -2 / 3 * 3", "-4 - 2 * 5 / 2"])
    fun `음수 그린 케이스`(inputValue: String) {
        val actual = CalculatorInputValue(inputValue)
        assertThat(actual.value).isEqualTo(inputValue)
    }
}
