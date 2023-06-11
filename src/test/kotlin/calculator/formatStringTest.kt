package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class formatStringTest {
    @Test
    fun `문자열 계산기`() {
        val inputString = "40+ 9 /7"
        Assertions.assertThat(calculateFromString(inputString)).isEqualTo(7)
    }
}
