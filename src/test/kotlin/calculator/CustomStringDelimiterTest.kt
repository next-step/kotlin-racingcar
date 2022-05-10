package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomStringDelimiterTest {
    @Test
    fun `문자열 사이즈 확인`() {
        val values = CustomStringDelimiter("2 + 3 * 4 / 2")
            .getValues()
        assertThat(values.size).isEqualTo(7)
    }
}
