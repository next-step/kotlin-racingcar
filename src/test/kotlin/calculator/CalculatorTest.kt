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
}