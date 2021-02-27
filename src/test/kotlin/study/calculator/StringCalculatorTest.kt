package study.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `빈 공백 문자인 경우 테스트`(input: String) {
        assertThatThrownBy { StringCalculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("문자열이 null 또는 빈 값입니다.")
    }

    @Test
    fun `null이 들어온 경우 테스트`() {
        assertThatThrownBy { StringCalculator.calculate(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("문자열이 null 또는 빈 값입니다.")
    }

    @Test
    fun `잘못된 연산자가 들어온 경우 테스트`() {
        val testStr = "2 + 3 x 4 / 2 - 1"

        assertThatThrownBy { StringCalculator.calculate(testStr) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("x는 존재하지 않는 연산자입니다.")
    }

    @Test
    fun `숫자가 잘못 들어간 경우(첫 번째 숫자)`() {
        val testStr = "w + 3 * 4 / 2 - 1"

        assertThatThrownBy { StringCalculator.calculate(testStr) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("잘못된 문자열이 피연산자로 입력되었습니다.")
    }

    @Test
    fun `숫자가 잘못 들어간 경우(첫 번째 외 숫자)`() {
        val testStr = "4 + 3 * w / 2 - 1"

        assertThatThrownBy { StringCalculator.calculate(testStr) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("잘못된 문자열이 피연산자로 입력되었습니다.")
    }

    @Test
    fun `연산자로 마지막이 끝난 경우`() {
        val testStr = "2 + 3 -"

        assertThatThrownBy { StringCalculator.calculate(testStr) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("피연산자가 존재하지 않습니다.")
    }

    @Test
    fun `더하기 테스트`() {
        val testStr = "2 + 3"
        assertThat(StringCalculator.calculate(testStr)).isEqualTo(5)
    }

    @Test
    fun `빼기 테스트`() {
        val testStr = "2 - 3"
        assertThat(StringCalculator.calculate(testStr)).isEqualTo(-1)
    }

    @Test
    fun `나누기 테스트`() {
        val testStr = "4 / 2"
        assertThat(StringCalculator.calculate(testStr)).isEqualTo(2)
    }

    @Test
    fun `곱하기 테스트`() {
        val testStr = "2 * 3"
        assertThat(StringCalculator.calculate(testStr)).isEqualTo(6)
    }

    @Test
    fun `나눠떨어지지 않는 경우 테스트`() {
        val testStr = "10 / 4"
        assertThat(StringCalculator.calculate(testStr)).isEqualTo(2)
    }

    @Test
    fun `0으로 나누는 경우 테스트`() {
        val testStr = "10 / 0"
        assertThatThrownBy { StringCalculator.calculate(testStr) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로 나눌 수 없습니다.")
    }

    @Test
    fun `정상 테스트(복합)`() {
        val testStr = "2 + 3 * 4 / 2 - 1"
        assertThat(StringCalculator.calculate(testStr)).isEqualTo(9)
    }
}
