package calculator

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @ParameterizedTest
    @NullSource
    fun `입력값이 null인 경우`(operation: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator().calculate(operation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 공백인 경우`(operation: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator().calculate(operation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [" 1 * 2 + 2 - 10", "4 5 * 10 - 2", "2 *+ 3 - 5 6 + 10"])
    fun `유효한 입력값이 아닌 경우`(operation: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator().calculate(operation)
        }
    }
}