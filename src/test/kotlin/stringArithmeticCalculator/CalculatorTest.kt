package stringArithmeticCalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringArithmeticCalculator.Calculator.Companion.add

class CalculatorTest {

    @Test
    fun `덧셈`() {
        assertThat(Calculator("2 + 3").result()).isEqualTo(5)
    }

    @Test
    fun `뺄셈`() {
        assertThat(Calculator("2 - 3").result()).isEqualTo(-1)
    }

    @Test
    fun `곱셈`() {
        assertThat(Calculator("2 * 3").result()).isEqualTo(6)
    }

    @Test
    fun `나눗셈`() {
        assertThat(Calculator("2 / 3").result()).isEqualTo(0)
    }

    @Test
    fun `문자열을 추가하여 계산하기`() {
        assertThat(Calculator("2 + 3").add("+ 3").result()).isEqualTo(8)
        assertThat(Calculator("2 + 3").add("+ 3").add("* 2").result()).isEqualTo(16)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 $ 2", "2 ( 2", "2 ! 3"])
    fun `사칙 연산이 아닌 기호`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator(input).result() }
            .withMessageContaining("번째 문자는 기호(+,-,*,/)가 와야합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / 0", "1 / 0", "0 / 0"])
    fun `나누기에 0이 들어가는 경우`(input: String) {
        assertThatExceptionOfType(ArithmeticException::class.java)
            .isThrownBy { Calculator(input).result() }
            .withMessage("0으로는 나눠지지가 않습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 빈 공백 문자일 경우`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator(input) }
            .withMessage("공백 문자는 올 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["/ / 2", "/ / /"])
    fun `숫자 값이 아닌 경우`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Calculator(input) }
            .withMessageContaining("번째 문자는 숫자가 와야합니다.")
    }
}
