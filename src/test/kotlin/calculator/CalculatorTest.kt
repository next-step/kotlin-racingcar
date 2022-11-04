package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3"])
    fun `덧셉`(operation: String) {
        assertThat(Calculator().calculate(operation)).isEqualTo(5.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 - 3"])
    fun `뺄셈`(operation: String) {
        assertThat(Calculator().calculate(operation)).isEqualTo(-1.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["5 * 9"])
    fun `곱셈`(operation: String) {
        assertThat(Calculator().calculate(operation)).isEqualTo(45.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["13 / 2"])
    fun `나눗셈`(operation: String) {
        assertThat(Calculator().calculate(operation)).isEqualTo(6.5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `사칙연산을 모두 포함하는 연산`(operation: String) {
        assertThat(Calculator().calculate(operation)).isEqualTo(10.0)
    }

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