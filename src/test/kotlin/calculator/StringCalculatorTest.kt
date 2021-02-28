package calculator

import org.assertj.core.api.Assertions.assertThat
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
    @ValueSource(ints = [-1, 0, 1, 154])
    fun `입력값이 단일 숫자면 해당 숫자를 반환`(integer: Int) {
        assertThat(calculator.calculate(integer.toString())).isEqualTo(integer)
    }
}
