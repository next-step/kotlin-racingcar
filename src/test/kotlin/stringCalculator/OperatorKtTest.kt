package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class OperatorKtTest {

    @Test
    fun `성공적으로 덧셈 연산을 수행한다`() {
        Assertions.assertThat(add(1, 2)).isEqualTo(3)
        Assertions.assertThat(add(6, 4)).isEqualTo(10)
    }

    @Test
    fun `성공적으로 뺄셈 연산을 수행한다`() {
        Assertions.assertThat(substrate(1, 2)).isEqualTo(-1)
        Assertions.assertThat(substrate(6, 4)).isEqualTo(2)
    }

    @Test
    fun `성공적으로 곱셈 연산을 수행한다`() {
        Assertions.assertThat(multiple(1, 2)).isEqualTo(2)
        Assertions.assertThat(multiple(6, 4)).isEqualTo(24)
    }

    @Test
    fun `성공적으로 나눗셈 연산을 수행한다`() {
        Assertions.assertThat(divide(1, 2)).isEqualTo(0)
        Assertions.assertThat(divide(6, 4)).isEqualTo(1)
    }

    @Test
    fun `0 으로 나누는 경우 div by zero로 ArithmeticException을 던진다`() {
        Assertions.assertThatThrownBy { divide(1, 0) }
            .isInstanceOf(java.lang.ArithmeticException::class.java)
    }
}
