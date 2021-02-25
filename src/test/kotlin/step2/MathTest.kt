package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MathTest {
    @Test
    fun `두 수의 합`() {
        assertThat(Calculation("3 + 4")).isEqualTo(7)
    }
}
