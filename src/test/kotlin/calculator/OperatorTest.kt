package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @ParameterizedTest
    @CsvSource("5, PLUS, 2, 7", "10, MINUS, 4, 6", "3, MULTIPLY, 5, 15", "4, DIVIDE, 2, 2")
    fun `연산자가 더하기라면 두 수를 더한 결과를 반환합니다`(left: Long, operator: Operator, right: Long, expected: Long) {
        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(expected)
    }
}
