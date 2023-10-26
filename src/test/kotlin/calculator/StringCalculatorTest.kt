package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3"])
    fun `덧셈`(input: String) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 - 3"])
    fun `뺄셈`(input: String) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(-1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 * 4"])
    fun `곱셈`(input: String) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(12)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 / 2"])
    fun `나눗셈`(input: String) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(2)
    }

    @Test
    fun `입력 값이 null 인 경우 IllegalArgumentException throw`() {
        val input = null
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("입력 값이 null 이거나 빈 공백 문자입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["   "])
    fun `입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String) {
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("입력 값이 null 이거나 빈 공백 문자입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 & 3"])
    fun `사칙 연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String) {
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("입력 값에 사칙 연산이 아닌 기호가 포함되었습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 /"])
    fun `올바른 계산식이 아닌 경우 IllegalArgumentException throw`(input: String) {
        assertThatThrownBy {
            StringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("올바른 계산식이 아닙니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `사칙 연산을 모두 포함하는 기능 구현`(input: String) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(10)
    }
}
