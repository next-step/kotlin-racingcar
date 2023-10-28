package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun calculatorTest() {
        assertThat(Calculator().run("3 + 4 / 1")).isEqualTo(7.0)
    }
}