
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.Calculator

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun ShouldThrowIllegalExceptionForEmptyStrings(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 ^ 2 @ 3"])
    fun ShouldThrowExceptionForUnknownOperators(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1a ^ 2 @ 3"])
    fun ShouldThrowExceptionForUnknownDigits(source: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 + 3"])
    fun ShouldMeetCalculationResult(source: String) {
        val calculator = Calculator(source)
        assertThat(calculator.result()).isEqualTo(6)
    }
}
