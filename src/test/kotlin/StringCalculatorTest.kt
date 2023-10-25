import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `입력값으로 공백문자가 전달되면 예외가 발생한다`() {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값으로 입렵 문자열 첫번째가 숫자가 아니면 예외가 발생한다`() {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("n+1")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값으로 사칙연산 기호 오른쪽이 숫자가 아니면 예외가 발생한다`() {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("1+n")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산이 주어지지 않을 경우 예외가 발생한다`(input: String, result: Int) {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("1]n")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
