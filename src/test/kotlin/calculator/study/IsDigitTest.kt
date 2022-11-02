package calculator.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IsDigitTest {

    @Test
    fun `1 is Digit`() {
        assertThat("1".all { it.isDigit() }).isTrue
    }

    @Test
    fun `1 isNot Digit`() {
        assertThat("-1".all { it.isDigit() }).isFalse
    }
}
