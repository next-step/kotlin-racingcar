import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `check input blank`() {
        val calculator = StringCalculator()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator(" ") }
            .withMessage("공백 또는 빈 문자열을 입력하셨습니다.")
    }

    @Test
    fun `check divide by zero`() {
        val calculator = StringCalculator()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator("3 / 0") }
            .withMessage("0으로 나눌 수 없습니다.")
    }

    @Test
    fun `check input operator type`() {

        val calculator = StringCalculator()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator("3 ? 1") }
            .withMessage("연산자는 [+, -, *, /]만 사용할 수 있습니다.")
    }

    @Test
    fun `check input number`() {

        val calculator = StringCalculator()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator("a + 3") }
            .withMessage("숫자외의 값을 입력할 수 없습니다.")
    }

    @Test
    fun `check Add value`() {
        val calculator = StringCalculator()
        val result = calculator.runStringCalculator("1 + 3")
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `check Minus value`() {
        val calculator = StringCalculator()
        val result = calculator.runStringCalculator("3 - 3")
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `check Multiply value`() {
        val calculator = StringCalculator()
        val result = calculator.runStringCalculator("27 * 2")
        assertThat(result).isEqualTo(54)
    }

    @Test
    fun `check Divide value`() {
        val calculator = StringCalculator()
        val result = calculator.runStringCalculator("64 / 8")
        assertThat(result).isEqualTo(8)
    }
}
