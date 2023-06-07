package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

class InfixCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["10 # 20", "10 + 20 - 3a", "10 + a - a"])
    fun `수식에 숫자와 사칙 연산이 아닌 문자가 있을 경우 IllegalArgumentException`(input: String) {
        Assertions.assertThatThrownBy { InfixCalculator(input).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("수식은 사칙연산과 숫자만 가능합니다.")
    }

    @Test
    fun `연산자가 숫자 수 보다 많거나 같은 경우`() {
        Assertions.assertThatThrownBy { InfixCalculator("10 / 20 * 30 + 10 - ").calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산자가 피연산자 보다 많을 수 없습니다.")
    }

    @Test
    fun `숫자가 연산자 보다 많은경우`() {
        Assertions.assertThatThrownBy { InfixCalculator("10 / 20 * 30 + 10 -").calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산자가 피연산자 보다 많을 수 없습니다.")
    }

    @Test
    fun `null 인 경우`() {
        Assertions.assertThatThrownBy { InfixCalculator(null).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("수식은 null 일 수 없습니다.")
    }

    @Test
    fun `공백 문자일 경우`() {
        Assertions.assertThatThrownBy { InfixCalculator("").calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("수식은 공백 일 수 없습니다.")
    }

    @Test
    fun `정상적인 계산식 일 경우`() {
        val result = InfixCalculator("2 + 3 * 4 * 2 / 2 - 5 ").calculate()
        Assertions.assertThat(result).isEqualTo(BigDecimal(15))
    }
}
