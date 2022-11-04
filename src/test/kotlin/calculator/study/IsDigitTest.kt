package calculator.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IsDigitTest {
    @Test
    fun `String 1은 숫자이다`() {
        assertThat("1".all { it.isDigit() }).isTrue
    }

    @Test
    fun `String -1은 숫자가 아니다`() {
        assertThat("-1".all { it.isDigit() }).isFalse
    }
}
