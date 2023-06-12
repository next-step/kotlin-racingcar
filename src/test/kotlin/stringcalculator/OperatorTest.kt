package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @ParameterizedTest
    @CsvSource(
        "1, 2, 3",
        "2, 5, 7",
        "3, 9, 12",
    )
    fun `+ 연산자가 있으면 두 수를 더한다`(first: Int, second: Int, expected: Int) {
        val result = Operator.executeOperation("+", first, second)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1, 5, -4",
        "10, 5, 5",
        "1, 1, 0",
        "100, 1, 99"
    )
    fun `- 연산자가 있으면 두 수를 뺀다`(first: Int, second: Int, expected: Int) {
        val result = Operator.executeOperation("-", first, second)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1, 5, 5",
        "100, 0, 0",
        "10, -10, -100"
    )
    fun `* 연산자가 있으면 두 수를 곱한다`(first: Int, second: Int, expected: Int) {
        val result = Operator.executeOperation("*", first, second)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "5, 1, 5",
        "10, 10, 1",
        "200, 100, 2"
    )
    fun `슬래시 연산자가 있으면 두 수를 나눈다`(first: Int, second: Int, expected: Int) {
        val result = Operator.executeOperation("/", first, second)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "100, 0",
        "100000, 0",
        "0, 0",
        "1, 0"
    )
    fun `0으로 나누면 IllegalArgumentException 발생`(first: Int, second: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { Operator.executeOperation("/", first, second)}
    }
}