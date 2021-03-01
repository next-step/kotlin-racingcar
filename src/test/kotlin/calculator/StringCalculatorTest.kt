package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
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
    @ValueSource(strings = ["2 ", " 3 + 4", "7 - 3 / 2 ", "\t9 * 2 / 3   "])
    fun `계산식의 양 옆은 트림을 하여 정상적으로 계산`(stringExpression: String) {
        assertThatCode {
            calculator.calculate(stringExpression).value
        }.doesNotThrowAnyException()
    }
}
