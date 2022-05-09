package stringcaculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculateTest {
    lateinit var calculator: StringCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringCalculator()
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4, 20", "2 + 3 * 4 / 2, 10", "3 * 2 / 1 + 10 - 5, 11"])
    fun `문자열 계산`(expression: String, expect: Int) {
        assertThat(calculator.calculate(expression)).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 # 1", "3 * #", " ", "3 / 0", "# # !"])
    fun `문자열 계산 예외`(expression: String) {
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate(expression)
        }
    }
}
