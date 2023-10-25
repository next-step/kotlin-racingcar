package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperationTest {

    private val number1 = 20
    private val number2 = 10

    @Test
    fun `더하기 연산`() {
        assertThat(Operation.of("+").block(number1, number2)).isEqualTo(30)
    }

    @Test
    fun `빼기 연산`() {
        assertThat(Operation.of("-").block(number1, number2)).isEqualTo(10)
    }

    @Test
    fun `곱하기 연산`() {
        assertThat(Operation.of("*").block(number1, number2)).isEqualTo(200)
    }

    @Test
    fun `나누기 연산`() {
        assertThat(Operation.of("/").block(number1, number2)).isEqualTo(2)
    }
}
