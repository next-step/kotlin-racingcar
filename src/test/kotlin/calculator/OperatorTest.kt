package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @ParameterizedTest
    @CsvSource("1, 2, 3", "2, 2, 4", "3, 2, 5")
    fun `연산자가 더하기라면 두 수를 더한 결과를 반환합니다`(left: Long, right: Long, expected: Long) {
        val operator: Operator = Operator.PLUS

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("5, 2, 3", "2, 2, 0", "4, 5, -1")
    fun `연산자가 빼기라면 두 수를 뺀 결과를 반환합니다`(left: Long, right: Long, expected: Long) {
        val operator: Operator = Operator.MINUS

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1, 2, 2", "5, 5, 25", "7, 2, 14")
    fun `연산자가 곱하기라면 두 수를 곱한 결과를 반환합니다`(left: Long, right: Long, expected: Long) {
        val operator: Operator = Operator.MULTIPLY

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2, 2, 1", "4, 2, 2", "15, 3, 5")
    fun `연산자가 나누기라면 두 수를 나눈 결과를 반환합니다`(left: Long, right: Long, expected: Long) {
        val operator: Operator = Operator.DIVIDE

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(expected)
    }
}
