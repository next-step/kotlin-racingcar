package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {
    private lateinit var calculator: StringCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "\t", "    ", "\n"])
    fun `입력값이 null 혹은 공백 문자열일 경우 IllegalArgumentException`(expression: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculator.calculate(expression) }
            .withMessage("The expression is null or blank. expression='$expression'")
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 +", "-", "/ 1", "1 4 5", "3 * 2 /", "1 - + 2", ""])
    fun `입력값이 계산식이 아니면 IllegalArgumentException`(expression: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.calculate(expression) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 ", " 3 + 4", "7 - 3 / 2 ", "\t9 * 2 / 3   "])
    fun `계산식의 양 옆은 트림을 하여 정상적으로 계산`(stringExpression: String) {
        assertThatCode {
            calculator.calculate(stringExpression).value
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @CsvSource("2, 2", "3 + 4, 7", "7 - 3 / 2, 2", "9 * 2 / 3, 6")
    fun `올바른 계산식이면 정상적으로 값을 반환`(stringExpression: String, result: Int) {
        assertThat(calculator.calculate(stringExpression)).isEqualTo(Scalar(result))
    }
}
