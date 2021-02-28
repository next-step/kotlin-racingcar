package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = ["1 + 2 + 3,6", "50 + 50 + 100 + 50, 250"])
    fun `덧셈 성공`(input: String, result: String) {
        assertThat(Calculator(input).calculate().toString()).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 - 2,-1", "100 - 50 - 1 - 5, 44"])
    fun `뺄셈 성공`(input: String, result: String) {
        assertThat(Calculator(input).calculate().toString()).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["10 * 2,20", "1 * 50 * 2 * 3, 300"])
    fun `곱 성공`(input: String, result: String) {
        assertThat(Calculator(input).calculate().toString()).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["5 / 2, 2", "11 / 3,3", "100 / 2 / 5,10"])
    fun `나눗 성공`(input: String, result: String) {
        assertThat(Calculator(input).calculate().toString()).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["100 * 2 + 10 / 10 - 1,20"])
    fun `혼합 연산 성공`(input: String, result: String) {
        assertThat(Calculator(input).calculate().toString()).isEqualTo(result)
    }
}
