package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `더하기`() {
        val calculator = Calculator()
        val actual = calculator.add(1, 2)
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        val calculator = Calculator()
        val actual = calculator.sub(1, 2)
        assertThat(actual).isEqualTo(-1)
    }
}
