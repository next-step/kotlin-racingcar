package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `정상 입력`() {
        val input = "1 + 2 * 3 / 4"
        assertThat(StringCalculator.calc(input)).isEqualTo(2)

        val input1 = "1 - 2 * 5"
        assertThat(StringCalculator.calc(input1)).isEqualTo(-5)

        val input2 = "10 / 2 + 3 * 5 - 39"
        assertThat(StringCalculator.calc(input2)).isEqualTo(1)
    }

    @Test
    fun `유효하지 않은 입력이 들어온다면 예외를 던진다`() {
        val error = "1 @ 2 # 3"
        assertThatThrownBy {
            StringCalculator.calc(error)
        }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 연산자 입니다.")
    }
}
