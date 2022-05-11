package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomStringDelimiterTest {
    @Test
    fun `문자열 사이즈 확인`() {
        val customStringDelimiter = CustomStringDelimiter("2 + 3 * 4 / 2")

        assertThat(customStringDelimiter.getOperands().size).isEqualTo(4)
        assertThat(customStringDelimiter.getOperators().size).isEqualTo(3)
    }
}
