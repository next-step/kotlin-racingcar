package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 빈 공백 문자일 경우`(input: String) {
        assertThatThrownBy { Calculator(input).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 없습니다.")
    }

    @Test
    fun `입력값이 null일 경우`() {
        assertThatThrownBy { Calculator(null).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 2", "1 2 3"])
    fun `연산자가 없을 경우`(input: String) {
        assertThatThrownBy { Calculator(input).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산자가 아닙니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["a - 1", "b + c"])
    fun `입력값이 숫자가 아닐 경우`(input: String) {
        assertThatThrownBy { Calculator(input).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 아닙니다.")
    }

    @ParameterizedTest
    @CsvSource("2 + 3,5", "2 - 3,-1", "2 * 3,6", "3 / 3,1")
    fun `연산자 1개일때 계산`(input: String, expected: Int) {
        assertThat(Calculator(input).calculate()).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2 + 3 - 1,4", "2 - 3 * 2,-2", "2 * 3 + 1,7", "3 / 3 * 3,3")
    fun `연산자 2개일때 계산`(input: String, expected: Int) {
        assertThat(Calculator(input).calculate()).isEqualTo(expected)
    }
    @ParameterizedTest
    @CsvSource("2 + 3 * 4 / 2,10")
    fun `연산 테스트`(input: String, expected: Int) {
        assertThat(Calculator(input).calculate()).isEqualTo(expected)
    }
}
