package calculator

import caculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["2 + 3"])
    fun `덧셈 테스트`(input: String) {
        assertThat(Calculator().calculate(input)).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 - 2"])
    fun `뺄셈 테스트`(input: String) {
        assertThat(Calculator().calculate(input)).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 * 2"])
    fun `곱셈 테스트`(input: String) {
        assertThat(Calculator().calculate(input)).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["6 / 3"])
    fun `나눗셈 테스트`(input: String) {
        assertThat(Calculator().calculate(input)).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `사칙 연산을 모두 포함하는 기능 구현`(input: String) {
        assertThat(Calculator().calculate(input)).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `입력값이 null이거나 빈 공백 문자일 경우`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { Calculator().calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 % 3 * 4 / 2", "3 ^ 3"])
    fun `사칙연산 기호가 아닌 경우`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { Calculator().calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / 0"])
    fun `0 으로 나누는 경우`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy { Calculator().calculate(input) }
    }
}
