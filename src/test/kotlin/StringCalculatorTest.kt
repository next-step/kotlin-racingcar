import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringCaculator.StringCalculator

class StringCalculatorTest {
    lateinit var calculator: StringCalculator

    fun init() {
        calculator = StringCalculator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `check input blank`(input: String) {
        init()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator(input) }
            .withMessage("공백 또는 빈 문자열을 입력하셨습니다.")
    }

    @Test
    fun `check divide by zero`() {
        init()
        val calculator = StringCalculator()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator("3 / 0") }
            .withMessage("0으로 나눌 수 없습니다.")
    }

    @Test
    fun `check input operator type`() {
        init()
        val calculator = StringCalculator()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator("3 ? 1") }
            .withMessage("연산자는 [+, -, *, /]만 사용할 수 있습니다.")
    }

    @Test
    fun `check input number`() {
        init()
        val calculator = StringCalculator()
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.runStringCalculator("a + 3") }
            .withMessage("숫자외의 값을 입력할 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("1 + 3", "3 * 3", "4 / 2", "5 - 1"))
    fun `check Four arithmetic operations`(inputCalculator: String) {
        init()
        val calculator = StringCalculator()
        val result = calculator.runStringCalculator(inputCalculator)
        assertThat(result).isEqualTo(result)
    }
}
