package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    internal fun setUp() {
        calculator = Calculator()
    }

    @CsvSource(value = ["2 + 5 - 4:3", "5 - 2 * 5:15", "2 * 2 * 2:8", "5 - 2 * 3 / 3:3"], delimiter = ':')
    @ParameterizedTest(name = "`{arguments}` 결과가 정상적으로 동작한다")
    internal fun calculateTest(input: String, expected: Int) {

        // when, then
        assertThat(calculator.calculate(input)).isEqualTo(expected)
    }

    @NullAndEmptySource
    @ParameterizedTest(name = "`{arguments}` 인경우 예외가 발생한다.")
    internal fun calculateExceptionTest(input: String?) {

        // when, then
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate(input)
        }
    }
}
