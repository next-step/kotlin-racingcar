package string

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @Test
    fun `빈 문자열이 입력될 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            Calculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백이 있는 빈 문자열이 입력될 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            Calculator.calculate("    ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "2//", "2++", "++9", "3/3/3/3/3+", "43+", "+43", "34*2-1/"])
    fun `비 정상적인 수식이 들어올 경우 IllegalArgumentException 에러가 발생한다`(input: String) {
        assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `문자열 계산기가 정상 동작한다`() {
        assertThat(Calculator.calculate("2+3")).isEqualTo(5)
        assertThat(Calculator.calculate("2-3")).isEqualTo(-1)
        assertThat(Calculator.calculate("2*3")).isEqualTo(6)
        assertThat(Calculator.calculate("3*3*3+3")).isEqualTo(30)
        assertThat(Calculator.calculate("9/3-1")).isEqualTo(2)
        assertThat(Calculator.calculate("3+2-1*4/2")).isEqualTo(8)
        assertThat(Calculator.calculate("7-4*3/9+9")).isEqualTo(10)
    }
}
