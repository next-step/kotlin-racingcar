package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OperatorTest {

    private var left: Long = 0
    private var right: Long = 0

    @BeforeEach
    fun setUp() {
        left = 1
        right = 2
    }

    @Test
    fun `연산자가 더하기라면 두 수를 더한 결과를 반환합니다`() {
        val operator: Operator = Operator.PLUS

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `연산자가 빼기라면 두 수를 뺀 결과를 반환합니다`() {
        val operator: Operator = Operator.MINUS

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `연산자가 곱하기라면 두 수를 곱한 결과를 반환합니다`() {
        val operator: Operator = Operator.MULTIPLY

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `연산자가 나누기라면 두 수를 나눈 결과를 반환합니다`() {
        val operator: Operator = Operator.DIVIDE

        val result: Long = operator.operation(left, right)

        assertThat(result).isEqualTo(0)
    }
}
