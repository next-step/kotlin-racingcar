package stringArithmeticCalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(strings = ["2 $ 2", "2 ( 2", "2 ! 3"])
    fun `사칙 연산이 아닌 기호`(input : String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ Calculator(input).result() }
            .withMessage("잘못 된 사칙연산입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / 0", "1 / 0", "0 / 0"])
    fun `나누기에 0이 들어가는 경우`(input : String) {
        assertThatExceptionOfType(ArithmeticException::class.java)
            .isThrownBy{ Calculator(input).result() }
            .withMessage("0으로는 나눠지지가 않습니다.")
    }


    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 빈 공백 문자일 경우`(input : String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ Calculator(input) }
            .withMessage("공백 문자는 올 수 없습니다.")
    }
}