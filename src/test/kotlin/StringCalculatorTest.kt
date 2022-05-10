import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @Test
    fun `null이 입력될 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            val stringCalculator = StringCalculator()
            stringCalculator.calculate(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `빈 문자열이 입력될 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            val stringCalculator = StringCalculator()
            stringCalculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "2//", "2++", "++9", "3/3/3/3/3+"])
    fun `비 정상적인 수식이 들어올 경우 IllegalArgumentException 에러가 발생한다`(input: String?) {
        assertThatThrownBy {
            val stringCalculator = StringCalculator()
            stringCalculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `sum 메소드에 3과 4를 전달하면 결과값은 7이다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.sum(3, 4)).isEqualTo(7)
    }

    @Test
    fun `minus 메소드에 9과 5를 전달하면 결과값은 4이다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.minus(9, 5)).isEqualTo(4)
    }

    @Test
    fun `multiple 메소드에 9과 5를 전달하면 결과값은 45이다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.multiple(9, 5)).isEqualTo(45)
    }

    @Test
    fun `divide 메소드에 9과 3를 전달하면 결과값은 3이다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.divide(9, 3)).isEqualTo(3)
    }

    @Test
    fun `문자열 계산기가 정상 동작한다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("2+3")).isEqualTo(5)
        assertThat(stringCalculator.calculate("2-3")).isEqualTo(-1)
        assertThat(stringCalculator.calculate("2*3")).isEqualTo(6)
        assertThat(stringCalculator.calculate("3*3*3+3")).isEqualTo(30)
        assertThat(stringCalculator.calculate("9/3-1")).isEqualTo(2)
        assertThat(stringCalculator.calculate("3+2-1*4/2")).isEqualTo(8)
        assertThat(stringCalculator.calculate("7-4*3/9+9")).isEqualTo(10)
    }
}
