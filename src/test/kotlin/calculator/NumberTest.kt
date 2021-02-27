package calculator

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
}
