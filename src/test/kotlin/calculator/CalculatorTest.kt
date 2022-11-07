package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    private val calculator = Calculator()

    @DisplayName("계산식 성공")
    @ParameterizedTest
    @MethodSource("correctParameters")
    fun `correctly calculate`(calculatorTestInput: CalculatorTestInput) {
        val result = calculator.calculate(calculatorTestInput.testData)
        assertThat(result).isEqualTo(calculatorTestInput.correctValue)
    }

    @DisplayName("입력 값이 공백일 경우 익셉션")
    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `input data is not blank`(input: String?) {
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .withMessage("input data is null, please check data")
    }

    @DisplayName("사칙연산 기호가 아닌 경우 익셉션")
    @ParameterizedTest
    @ValueSource(strings = ["1 ? 2", "2 ! 3", "3 $ 4"])
    fun `unknown operand exception`(input: String?) {
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .withMessage("It is not four basic arithmetic operations")
    }

    private fun correctParameters() = listOf(
        CalculatorTestInput("2 + 3 * 4 / 2", 10),
        CalculatorTestInput("3 - 1 * 5 / 2", 5),
        CalculatorTestInput("1 + 1 * 2 / 4", 1),
        CalculatorTestInput("20 + 1 * 1 / 3", 7),
        CalculatorTestInput("13 + 3 * 2 / 4", 8),
    )
}
