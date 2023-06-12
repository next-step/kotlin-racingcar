package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `문자열 계산기`() {
        Assertions.assertThat(StringCalculator().calculate("40+ 9 /7")).isEqualTo(7)
        Assertions.assertThat(StringCalculator().calculate("49- 9 /1")).isEqualTo(40)
        Assertions.assertThat(StringCalculator().calculate("7 *6 /6")).isEqualTo(7)
    }
}
