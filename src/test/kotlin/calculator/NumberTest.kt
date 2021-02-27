package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class NumberTest {

    @Test
    fun `Number 의 값이 빈 공백이면 예외를 반환한다`() {
        assertThatThrownBy {
            Number.of("")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("the value must not empty")
    }

    @Test
    fun `Number 의 값이 숫자가 아니면 예외를 반환한다`() {
        assertThatThrownBy {
            Number.of("+ ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("the value must number")
    }

    @Test
    fun `2 와 2 를 더하면 4 가 된다`() {
        val num1 = Number.of("2")
        val num2 = Number.of("2")
        assertThat(num1 + num2).isEqualTo(Number.of("4"))
    }

    @Test
    fun `2 와 2 를 빼면 0 이 된다`() {
        val num1 = Number.of("2")
        val num2 = Number.of("2")
        assertThat(num1 - num2).isEqualTo(Number.of("0"))
    }

    @Test
    fun `2 와 4 를 곱하면 8 이 된다`() {
        val num1 = Number.of("2")
        val num2 = Number.of("4")
        assertThat(num1 * num2).isEqualTo(Number.of("8"))
    }

    @Test
    fun `4 와 2 를 나누면 2 가 된다`() {
        val num1 = Number.of("4")
        val num2 = Number.of("2")
        assertThat(num1 / num2).isEqualTo(Number.of("2"))
    }
}
