package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "1+2+3+4,10",
        "2+3*4/2,10",
        "1 + 2 + 3 + 4, 10",
        "2 + 3 * 4 / 2, 10",
        "2      +  3      *   4      /   2 ,10",
    )
    fun calculate(string: String, result: Double) {
        assertThat(Calculator.calculate(string)).isEqualTo(result)
    }

    @Test
    fun `empty error`() {
        Assertions.assertThatThrownBy {
            Calculator.calculate("")
        }.hasMessageContaining(StringParser.emptyMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2a", "1 x 3  "])
    fun `input error`(string: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(string)
        }.hasMessageContaining(StringParser.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2..2", "1 + 3.2.1  "])
    fun `multiple points error`(string: String) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(string)
        }.hasMessageContaining("multiple points")
    }
}