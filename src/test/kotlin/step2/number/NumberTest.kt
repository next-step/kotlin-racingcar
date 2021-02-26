package step2.number

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class NumberTest {
    @Test
    fun `올바르지 않은 문자로 숫자를 생성하려는 경우 exception`() {
        // given
        val wrongNumber = "a"

        // when

        // then
        assertThatThrownBy { Number.of(wrongNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$wrongNumber : 숫자가 아닙니다.")
    }
}
