package string

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "           "])
    fun `빈 문자열 혹은 공백만 있는 문자열이 들어올 경우 IllegalArgumentException 에러가 발생한다`(input: String) {
        assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 비어있습니다")
    }

    @Test
    fun `유효한 연산자가 아닌 값이 들어올 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            Calculator.calculate("2!3")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자 혹은 유효한 연산자가 아닙니다")
    }

    @Test
    fun `문자열 입력값 양 끝이 숫자가 아닐 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            Calculator.calculate("!!!")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 수식입니다")
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "2//", "2++", "++9", "3/3/3/3/3+", "43+", "+43", "34*2-1/"])
    fun `비 정상적인 수식이 들어올 경우 IllegalArgumentException 에러가 발생한다`(input: String) {
        assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["2+3,5", "2-3,-1", "2*3,6", "3*3*3+3,30", "9/3-1,2", "3+2-1*4/2,8", "7-4*3/9+9,10"])
    fun `문자열 계산기가 정상 동작한다`(test: String, expect: Int) {
        assertThat(Calculator.calculate(test)).isEqualTo(expect)
    }
}
